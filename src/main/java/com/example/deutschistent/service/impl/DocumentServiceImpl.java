package com.example.deutschistent.service.impl;


import com.example.deutschistent.dto.DocumentDto;
import com.example.deutschistent.entity.Document;
import com.example.deutschistent.exceptions.NotFoundException;
import com.example.deutschistent.repositories.DocumentRepository;
import com.example.deutschistent.service.DocumentService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final DocumentRepository documentRepository;

    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public List<Document> getAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document findById(Long id) {
        return documentRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found!"));
    }

    @Override
    public void deleteById(Long id) {
        documentRepository.deleteById(id);
    }
}
