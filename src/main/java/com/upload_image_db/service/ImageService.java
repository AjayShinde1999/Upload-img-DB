package com.upload_image_db.service;

import com.upload_image_db.dto.ImageDto;
import com.upload_image_db.entity.Image;
import com.upload_image_db.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(ImageDto imageDto) throws IOException {
        Image image = new Image();
        image.setType(imageDto.getFile().getContentType());
        image.setData(imageDto.getFile().getBytes());
        imageRepository.save(image);
    }

    public Image getImage(long id) {
       return imageRepository.findById(id).get();

    }
}
