package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "productCategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class productCategory {
    @Id
    private String id;
    private int categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryImage;
}
