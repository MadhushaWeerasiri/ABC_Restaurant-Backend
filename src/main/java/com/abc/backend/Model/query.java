package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "query")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class query {
    @Id
    private String queryId;
    private String queryCustomer;
    private String queryStaff;
    private String queryText;
    private String queryTime;
}
