package com.example.deutschistent.service.impl;

import com.example.deutschistent.dto.DocumentDto;
import com.example.deutschistent.entity.Document;
import com.example.deutschistent.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl {
    private final DocumentRepository documentRepository;



}
