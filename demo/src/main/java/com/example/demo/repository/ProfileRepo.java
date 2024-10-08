package com.example.demo.repository;

import com.example.demo.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile,Long> {
    Profile findByProfileName(String profileName);

}

