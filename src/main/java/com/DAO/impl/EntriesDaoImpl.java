package com.DAO.impl;

import com.DAO.EntriesDao;
import com.model.Entry;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class EntriesDaoImpl implements EntriesDao {
    private Map<Integer, Entry> entries = new HashMap<>();
    private int idCounter = 1;
    private TopicsDaoImpl topicDAO;

    public EntriesDaoImpl(TopicsDaoImpl topicDAO) {
        this.topicDAO = topicDAO;
    }

    @Override
    public Entry addEntry(Entry entry) {
        if (entry == null) {
            System.out.println("Error: Entry cannot be null");
            return null;
        }

        // Validate topic exists
        if (topicDAO.getTopic(entry.getTopicId()) == null) {
            System.out.println("Error: Topic ID " + entry.getTopicId() + " does not exist");
            return null;
        }

        if (entry.getNote() == null || entry.getNote().trim().isEmpty()) {
            System.out.println("Error: Entry note cannot be empty");
            return null;
        }

        entry.setId(idCounter++);
        entry.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        entries.put(entry.getId(), entry);
        return entry;
    }

    @Override
    public Entry getEntry(int id) {
        return entries.get(id);
    }

    @Override
    public List<Entry> getAllEntries() {
        return new ArrayList<>(entries.values());
    }
}
