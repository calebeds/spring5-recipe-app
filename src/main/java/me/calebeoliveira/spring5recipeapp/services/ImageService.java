package me.calebeoliveira.spring5recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(long id, MultipartFile file);
}
