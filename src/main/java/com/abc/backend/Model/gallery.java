package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "gallery")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class gallery {
    @Id
    private String imgId;
    private String imgName;
    private String imgPath;
    private String imgDescription;
    private String imgType;
    private int uploadedBy;
    private String uploadedDate;
}
