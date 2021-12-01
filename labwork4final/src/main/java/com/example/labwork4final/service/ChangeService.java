package com.example.labwork4final.service;

import com.example.labwork4final.model.DbChange;
import com.example.labwork4final.repository.ChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeService {

    @Autowired
    private ChangeRepository changeRepository;

    public void save(DbChange change) {
        change.setId(getNextId());
        changeRepository.save(change);
    }

    public Long getNextId() {
        long count = changeRepository.count();
        long id = ++count;
        while (changeRepository.existsById(id)) {
            ++id;
        }
        return id;
    }
}
