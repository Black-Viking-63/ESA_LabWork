package org.example.labwork2final.repository;

import org.example.labwork2final.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GameRepository  extends JpaRepository<Game, Long> {
}

