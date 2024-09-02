package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class reservation {
    @Id
    private String reservationId;
    private String customerId;
    private String[] reservationProducts;
    private int reservationType;
    private String reservationDate;
    private String reservationTime;
    private String reservationNote;
    private String reservationLocation;
    private String reservationPlacedTime;
    private int reservtionTotal;
    private String reservationStatus;
}
