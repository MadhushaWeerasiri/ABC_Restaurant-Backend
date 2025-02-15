package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "offer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class offer {
    @Id
    private String id;
    private String offerId;
    private String offerName;
    private String offerDescription;
    private String offerImage;
    private int offerPrice;
    private String offerDiscount;
    private String offerStatus;
    private String offerStartDate;
    private String offerEndDate;
    private int[] offerCategory;
}
