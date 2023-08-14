package com.exampleWebApp.service;

import com.exampleWebApp.entity.Photo;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@Component
@Service
public class PhotoService {

    private Map<String, Photo> db1= new HashMap<>(){{
//       put("1", new Photo("1", "Hello1.jpg"));
    }};

    public Collection<Photo> get() {
        return db1.values();
    }

    public Photo get(String id) {
        return db1.get(id);
    }

    public Photo remove(String id) {
       return db1.remove(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setId(UUID.randomUUID().toString());
        photo.setFileName(fileName);
        photo.setData(data);
        db1.put(photo.getId(),photo);
        return photo;

    }
}
