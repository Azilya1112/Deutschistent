package com.example.deutschistent.controller;


import com.example.deutschistent.entity.Document;
import com.example.deutschistent.service.DocumentService;
import com.example.deutschistent.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/documents")
public class DocumentController {

    private final DocumentService documentService;
    private final UserService userService;


    @PostMapping("/save")
    public ResponseEntity<Document> saveDocument(@RequestBody Document document) {
        Document savedDocument = documentService.save(document);
        return new ResponseEntity<>(savedDocument, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAll();
        return new ResponseEntity<>(documents, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Document document = documentService.findById(id);
        if (document != null) {
            return new ResponseEntity<>(document, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDocumentById(@PathVariable Long id) {
        Document document = documentService.findById(id);
        if (document != null) {
            documentService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{userId}/documents/upload")
    public ResponseEntity<String> uploadDocument(@PathVariable Long userId, @RequestParam("file") MultipartFile file) {
        try {
            userService.saveUserDocument(userId, file);
            return ResponseEntity.ok("Document uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload document.");
        }
    }
}
