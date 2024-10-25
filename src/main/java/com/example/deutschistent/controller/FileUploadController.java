package com.example.deutschistent.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileUploadController {

    // Директория для сохранения файлов
    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        // Проверяем, что файл не пуст
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        // Проверка типа файла
        String contentType = file.getContentType();
        if (!"image/jpeg".equals(contentType) && !"application/pdf".equals(contentType)) {
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Only .jpg and .pdf files are allowed");
        }

        // Сохранение файла
        try {
            String filePath = uploadDir + File.separator + file.getOriginalFilename();
            file.transferTo(new File(filePath));
            return ResponseEntity.status(HttpStatus.OK).body("File uploaded successfully: " + filePath);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File upload failed");
        }
    }
}
