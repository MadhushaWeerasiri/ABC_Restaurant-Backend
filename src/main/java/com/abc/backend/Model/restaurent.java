package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "restaurent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class restaurent {
    @Id
    private String locationId;
    private String locationName;
    private String locationAddress;
    private String locationCity;
    private String locationDistrict;
    private String locationPhone;
    private int[] locationFacilities;
}
