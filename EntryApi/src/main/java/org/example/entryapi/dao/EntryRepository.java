package org.example.entryapi.dao;

import org.example.entryapi.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Integer> {
    List<Entry> findAllByOrderByTitle();
}
