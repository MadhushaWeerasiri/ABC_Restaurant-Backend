package com.abc.backend.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class role {
    @Id
    private String id;
    private int roleID;
    private String roleName;
}
