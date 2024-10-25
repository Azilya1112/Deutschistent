package com.example.deutschistent.service.impl;

import com.example.deutschistent.entity.Image;
import com.example.deutschistent.entity.User;
import com.example.deutschistent.exceptions.NotFoundException;
import com.example.deutschistent.repositories.ImageRepository;
import com.example.deutschistent.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl {
    private final UserRepository userRepository;
    private final ImageRepository imageRepository;

    public void saveUserProfileImage(Long id, MultipartFile file) throws IOException {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));

        Image image = new Image();
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setImage(file.getBytes());

        user.setImage(image);

        imageRepository.save(image);
        userRepository.save(user);
    }


}
