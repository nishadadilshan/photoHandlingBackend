package com.exampleWebApp.controller;

import com.exampleWebApp.entity.Photo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
public class PhotoController {

//    private List<Photo> db = List.of(new Photo("1","photo1.jpg"));
    private Map<String, Photo> db1= new HashMap<>(){{
//       put("1", new Photo("1", "Hello1.jpg"));
    }};

    @GetMapping("/Hello")
    public  String hello(){
        return "Hello World";
    }

    @GetMapping("/photo")
    public Collection<Photo> get(){
        return  db1.values();
    }

    @GetMapping("/photo/{id}")
    public Photo get(@PathVariable String id){
        Photo photo = db1.get(id);

        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return photo;
    }
    @DeleteMapping("/photo/{id}")
    public void delete(@PathVariable String id){
        Photo photo = db1.remove(id);
        if(photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    @PostMapping("/photo")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        Photo photo = new Photo();
     photo.setId(UUID.randomUUID().toString());
     photo.setFileName(file.getOriginalFilename());
     photo.setData(file.getBytes());
     db1.put(photo.getId(), photo);
     return photo;
    }


}
