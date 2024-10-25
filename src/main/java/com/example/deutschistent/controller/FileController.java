package com.example.deutschistent.controller;

import com.example.deutschistent.entity.ImageDoc;
import com.example.deutschistent.repositories.ImageDocRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/files")
public class FileController {

    private final ImageDocRepository imageDocRepository;

    public FileController(ImageDocRepository imageDocRepository) {
        this.imageDocRepository = imageDocRepository;
    }

    @Operation(summary = "Upload an image file", description = "Allows you to upload an image and save it to the database")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadFile(
            @Parameter(description = "Image file to upload", required = true)
            @RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        try {
            // Преобразование файла в байты
            byte[] data = file.getBytes();

            // Создаём сущность ImageDoc для хранения в базе данных
            ImageDoc imageDoc = new ImageDoc(file.getOriginalFilename(), file.getContentType(), data);

            // Сохраняем файл в базе данных
            imageDocRepository.save(imageDoc);

            return ResponseEntity.status(HttpStatus.OK).body("Image uploaded and saved to database successfully");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image upload failed");
        }
    }

    // Пример метода для получения файла по id
    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        ImageDoc imageDoc = imageDocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found with id " + id));

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(imageDoc.getType()))
                .header("Content-Disposition", "attachment; filename=\"" + imageDoc.getName() + "\"")
                .body(imageDoc.getData());
    }
}
