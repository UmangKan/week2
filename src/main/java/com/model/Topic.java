package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
//in model only data logic is defined the variable data type is same as DB data type

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable {
    private int id;
    private String name;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Topic(String name)
    {
        this.name = name;
    }

}
