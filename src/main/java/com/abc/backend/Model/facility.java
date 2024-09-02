package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "facility")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class facility {
    @Id
    private String id;
    private int facilityId;
    private String facilityName;
    private String facilityDescription;
}
