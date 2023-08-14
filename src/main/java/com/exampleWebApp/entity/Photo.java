package com.exampleWebApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Photo {
    private String id;
    private String contentType;
    @NotEmpty
    private String fileName;
    @JsonIgnore
    private byte[] data;
}
