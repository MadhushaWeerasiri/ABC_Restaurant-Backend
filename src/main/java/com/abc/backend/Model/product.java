package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class product {
    @Id
    private String productId;
    private String productName;
    private String productDescription;
    private String productImage;
    private int productPrice;
    private int[] productCategory;
    private String productStatus;
}
