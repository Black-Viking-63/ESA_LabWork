package com.example.labwork4final.repository;

import com.example.labwork4final.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
