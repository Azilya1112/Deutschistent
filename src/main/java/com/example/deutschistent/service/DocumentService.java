package com.example.deutschistent.service;


import com.example.deutschistent.entity.Document;

import java.util.List;

public interface DocumentService {
    Document save(Document document);

    List<Document> getAll();

    Document findById(Long id);

    void deleteById(Long id);


}
