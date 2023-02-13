package com.example.onlinenotesmilitaryedition.dao;

import com.example.onlinenotesmilitaryedition.models.Note;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NoteService {

    Note findByUserId(long userId);

    Note findById(long id);

    void save(Note note);

    List<Note> findAllByUserId(long userId);

    void deleteById(long id);

}
