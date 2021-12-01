package org.example.labwork2final.repository;

import org.example.labwork2final.model.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EditorRepository extends JpaRepository<Editor, Long> {
}
