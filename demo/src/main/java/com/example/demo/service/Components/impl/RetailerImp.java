package com.example.demo.service.Components.impl;

import com.example.demo.dto.ExtendedRes;
import com.example.demo.dto.ImageUploadRes;
import com.example.demo.dto.MinimalRes;
import com.example.demo.dto.ShopDto;
import com.example.demo.model.Location;
import com.example.demo.model.MyUser;
import com.example.demo.model.Shop;
import com.example.demo.model.ShopImages;
import com.example.demo.repository.LocationRepository;
import com.example.demo.repository.MyUserRepo;
import com.example.demo.repository.ShopImagesRepo;
import com.example.demo.repository.ShopRepo;
import com.example.demo.service.Components.main.RetailerGuide;
import com.example.demo.utils.FileUploader;
import com.example.demo.utils.LocationSplitter;
import com.example.demo.utils.MyDtoMapper;
import com.example.demo.utils.UserName;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RetailerImp implements RetailerGuide {

    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private LocationRepository locationRepo;
    @Autowired
    private FileUploader fileUploader;
    @Autowired
    private ShopImagesRepo shopImagesRepo;
    @Autowired
    private MyUserRepo myUserRepo;


    @Override
    public ExtendedRes addShopUpdate(ShopDto shopDto) {
        MyUser retailer = myUserRepo.findByEmail(UserName.getUsername());
        if(retailer == null){
            return ExtendedRes.builder()
                    .status(400)
                    .message("Retailer not found")
                    .build();
        }else{
            if(shopDto.getShopId() == null ||shopDto.getShopId() == 0 ){
                Shop newShop = new Shop();
                newShop.setMyUser(retailer);
                newShop.setShopName(shopDto.getShopName());
                newShop.setRegion(shopDto.getRegion());
                newShop.setShopType(shopDto.getShopType());
                Location location = new Location();
                try{
                    location = LocationSplitter.getLocation(shopDto.getLocationLatLong());
                }catch(Exception e){
                    log.info(e.getLocalizedMessage());
                    return ExtendedRes.builder()
                            .status(400)
                            .message("Location in bad format")
                            .build();
                }
                location = locationRepo.save(location);
                newShop.setShopLocation(location);
                Shop finalShop = shopRepo.save(newShop);
                return ExtendedRes.builder()
                        .status(200)
                        .message("Created shop")
                        .body(finalShop)
                        .build();
            }else{
                Shop oldShop = shopRepo.findById(shopDto.getShopId()).get();
                if(oldShop == null){
                    return ExtendedRes.builder()
                            .status(400)
                            .message("shop not found")
                            .build();
                }
                Location oldLocation = oldShop.getShopLocation();
                Location newLocation=new Location();
                try{
                    newLocation = LocationSplitter.getLocation(shopDto.getLocationLatLong());
                }catch(Exception e){
                    log.info(e.getLocalizedMessage());
                    return ExtendedRes.builder()
                            .status(400)
                            .message("Location in bad format")
                            .build();
                }
                newLocation.setId(oldLocation.getId());
                newLocation = locationRepo.save(newLocation);
                oldShop.setShopLocation(newLocation);
                oldShop.setShopName(shopDto.getShopName());
                Shop shop = shopRepo.save(oldShop);
                return ExtendedRes.builder()
                        .status(200)
                        .message("Updated shop")
                        .body(shop)
                        .build();
            }
        }
    }
    @Override
    public ExtendedRes getShops() {
        MyUser retailer = myUserRepo.findByEmail(UserName.getUsername());
        List<Shop> shops = shopRepo.findByMyUserAndSoftDelete(retailer, false);
        List<ShopDto> shopDtos = shops.stream().map(RetailerImp::toDto).collect(Collectors.toList());
        return ExtendedRes.builder()
                .status(200)
                .message("list of shops")
                .body(shopDtos)
                .build();
    }
    @Override
    public ExtendedRes getShopById(Long shopId) {
        Shop shop = shopRepo.findById(shopId).get();
        return ExtendedRes.builder()
                .status(200)
                .message("got shop")
                .body(toDto(shop))
                .build();
    }

    private static ShopDto toDto(Shop shop){
        return ShopDto.builder()
                .shopName(shop.getShopName())
                .shopId(shop.getShopId())
                .region(shop.getRegion())
                .shopType(shop.getShopType())
                .locationLatLong(LocationSplitter.joinLocation(shop.getShopLocation()))
                .build();
    }

    @Override
    public MinimalRes deleteShop(Long shopId){
        MyUser retailer = myUserRepo.findByEmail(UserName.getUsername());
        Shop shop = shopRepo.findByShopIdAndMyUser(shopId, retailer);
        if(shop == null){
            return MinimalRes.builder()
                    .status(400)
                    .message("Shop not found")
                    .build();
        }

        shop.setSoftDelete(true);
        List<ShopImages> shopImages = shopImagesRepo.findByShop(shop);

        shopImages.forEach((image)->{
            if(image.isCloud()){
                fileUploader.deleteCloudPicture(uploadLink, image.getPublicId());
            }else{
                fileUploader.deleteLocalPicture(filePath+"/"+image.getPicture());
            }
        });

        shopImagesRepo.deleteAll(shopImages);
        shopRepo.save(shop);
        return MinimalRes.builder()
                .status(200)
                .message("Shop deleted")
                .build();
    }

    @Value("${shop.pic}")
    String filePath;

    @Value("${uploader.link}")
    String uploadLink;


    @Override
    public MinimalRes addShopWithPictures(String shopDto, List<MultipartFile> images) {
        ShopDto shopDto2 = MyDtoMapper.stringToClass(shopDto, ShopDto.class);
        ExtendedRes extendedRes = this.addShopUpdate(shopDto2);
        List<ShopImages> shopImages = new ArrayList<>();
        images.forEach(image->{
            ImageUploadRes imageUploadRes = fileUploader.uploadImage(filePath, image, uploadLink+"/uploader/upload");
            ShopImages shopImage = new ShopImages();
            if(imageUploadRes.getPublicId() != null){
                shopImage.setCloud(true);
                shopImage.setPublicId(imageUploadRes.getPublicId());
            }
            shopImage.setPicture(imageUploadRes.getFileName());
            shopImage.setShop(MyDtoMapper.mapDtoToClass(extendedRes.getBody(), Shop.class));
            shopImages.add(shopImage);
        });

        shopImagesRepo.saveAll(shopImages);
        return MinimalRes.builder()
                .status(200)
                .message("Shop created")
                .build();
    }
}
