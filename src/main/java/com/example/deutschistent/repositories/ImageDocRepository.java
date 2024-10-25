package com.example.deutschistent.repositories;

import com.example.deutschistent.entity.ImageDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageDocRepository extends JpaRepository<ImageDoc, Long> {
}
