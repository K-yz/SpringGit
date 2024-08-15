package org.example.entryapi.service;

import org.example.entryapi.entity.Entry;

import java.util.List;

public interface EntryService {
    public void save(Entry theentry);
    public List<Entry> findAll();
    public Entry findById(int TheId);
    public void deleteById(int TheId);
}
