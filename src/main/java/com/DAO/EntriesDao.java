package com.DAO;

import com.model.Entry;

import java.util.List;

public interface EntriesDao {
    Entry addEntry(Entry entry);
    Entry getEntry(int id);
    List<Entry> getAllEntries();
}
