package com.example.labwork4final.repository;

import com.example.labwork4final.model.DbChange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChangeRepository extends JpaRepository<DbChange, Long> {
}

