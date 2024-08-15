package org.example.entryapi.service;

import org.example.entryapi.dao.EntryRepository;
import org.example.entryapi.entity.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntryServicelmpl implements EntryService {
    private  final EntryRepository entryRepository;
    @Autowired
    public EntryServicelmpl(EntryRepository theEntryRepository) {
        this.entryRepository = theEntryRepository;
    }


    @Override
    public void save(Entry theentry) {
        entryRepository.save(theentry);
    }

    @Override
    public List<Entry> findAll() {
        return entryRepository.findAllByOrderByTitle();
    }

    @Override
    public Entry findById(int theId) {
        Optional<Entry> result = entryRepository.findById(theId);
        Entry theEntry = null;
        if (result.isPresent()) {
            theEntry = result.get();
        }
        else {
            throw new RuntimeException("Entry not find id" + theId);
        }
        return theEntry;
    }

    @Override
    public void deleteById(int id) {
        entryRepository.deleteById(id);
    }
}
