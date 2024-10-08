package com.example.demo.controller;


import com.example.demo.dto.ExtendedRes;
import com.example.demo.dto.ImageDeleteDto;
import com.example.demo.dto.MinimalRes;
import com.example.demo.service.Components.main.ImageGuide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("*")
@RequestMapping("/image")
public class ImageController {
    @Autowired
    ImageGuide imageService;

//    @Operation(
//            summary = "Upload a file",
//            description = "The filename should be called 'file' when adding to form data, (for all images)",
//            requestBody = @RequestBody(
//                    content = @Content(
//                            mediaType = "multipart/form-data",
//                            schema = @Schema(type ="string", name = "file", format = "binary")
//                    )
//            )
//    )

    @PostMapping("/profilePic")
    public MinimalRes uploadProfilePic(@RequestPart("file") MultipartFile file){
        return imageService.uploadProfilePic(file);
    }
//    @Operation(
//            summary = "Upload a file",
//            requestBody = @RequestBody(
//                    content = @Content(
//                            mediaType = "multipart/form-data",
//                            schema = @Schema(type ="string", name = "file", format = "binary")
//                    )
//            )
//    )
    @PostMapping("/depotPic/{depotId}")
    public MinimalRes uploadDepotPic(@PathVariable long depotId,@RequestPart("file") MultipartFile file){
        return imageService.uploadDepotPic(depotId, file);
    }

    @GetMapping("/getPic/{who}/{imageName}")
    public ResponseEntity<byte[]> getLocalImage(@PathVariable(value = "who") String who, @PathVariable(value = "imageName")  String imageName){
        return imageService.getLocalImage(who, imageName);
    }
//    @Operation(
//            summary = "Upload a file",
//            requestBody = @RequestBody(
//                    content = @Content(
//                            mediaType = "multipart/form-data",
//                            schema = @Schema(type ="string", name = "file", format = "binary")
//                    )
//            )
//    )
    @PostMapping("/product/{qattid}")
    public MinimalRes updateProductAttribute(@PathVariable Long qattid,@RequestPart("file") MultipartFile file){
        return imageService.updateProductAttributePic(qattid, file);
    }

    @GetMapping("/profile/getPicDetails")
    public ExtendedRes getPicDetails(){
        return imageService.getProfilePic();
    }

    @GetMapping("/getShopImages/{shopId}")
    public ExtendedRes getShopImages(@PathVariable Long shopId){
        return imageService.getShopImages(shopId);
    }

    @GetMapping("/getTruckImages/{truckId}")
    public ExtendedRes getTruckImages(@PathVariable Long truckId){
        return imageService.getTruckImages(truckId);
    }

    @PostMapping("/deleteTruckImages")
    public MinimalRes deleteTruckImages(@org.springframework.web.bind.annotation.RequestBody ImageDeleteDto imageDeleteDto){
        return imageService.deleteTruckImages(imageDeleteDto);
    }

    @PostMapping("/deleteShopImages")
    public MinimalRes deleteShopImages(@RequestBody ImageDeleteDto imageDeleteDto){
        return imageService.deleteShopImages(imageDeleteDto);
    }


}
