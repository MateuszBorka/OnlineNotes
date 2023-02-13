package com.example.onlinenotesmilitaryedition.dao;

import com.example.onlinenotesmilitaryedition.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteDao extends JpaRepository<Note, Long> {
        Note findByUserId(long userId);

        Note findById(long id);

        List<Note> findAllByUserId(long userId);


}
