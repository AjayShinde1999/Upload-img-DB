package com.upload_image_db.controller;

import com.upload_image_db.dto.ImageDto;
import com.upload_image_db.entity.Image;
import com.upload_image_db.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(path = "/api")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/image")
    public void saveImage(ImageDto imageDto) throws IOException {
        imageService.saveImage(imageDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable long id) {
        Image image = imageService.getImage(id);
        return ResponseEntity.ok().header("Content-Type", image.getType()).body(image.getData());
    }
}
