package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "cart")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class cart {
    @Id
    private String id;
    private String customerId;
    private String productId;
    private int productQuantity;
}
