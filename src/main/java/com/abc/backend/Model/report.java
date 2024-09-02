package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "report")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class report {
    @Id
    private String reportId;
    private String reportName;
    private String reportDescription;
    private String reportType;
    private int generatedBy;
    private String generatedDate;
    private String reportPath;
}
