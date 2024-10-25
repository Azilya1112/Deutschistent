package com.example.deutschistent.entity;

import jakarta.persistence.*;

@Entity
@Table(name="image_doc")
public class ImageDoc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @Lob // Для хранения больших двоичных данных (BLOB)
    private byte[] data;

    // Конструкторы, геттеры и сеттеры

    public ImageDoc() {
    }

    public ImageDoc(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}