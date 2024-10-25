package com.example.deutschistent.dto;

import com.example.deutschistent.enums.Type;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DocumentDto {
    Long id;
    String title;
    String uploaderName;
    Long fileSize;
    LocalDateTime uploadDate;
    Type type;
}
