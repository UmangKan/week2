package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
    private int id;
    private int topicId;
    private String note;
    private Timestamp createdAt;

    public Entry(int topicId, String note) {
        this.topicId = topicId;
        this.note = note;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }
}
