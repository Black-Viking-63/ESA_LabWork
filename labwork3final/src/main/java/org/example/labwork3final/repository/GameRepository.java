package org.example.labwork3final.repository;

import org.example.labwork3final.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GameRepository  extends JpaRepository<Game, Long> {
}
