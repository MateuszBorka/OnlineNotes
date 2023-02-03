package com.example.onlinenotesmilitaryedition.dao;

import com.example.onlinenotesmilitaryedition.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteDao noteDao;


    @Override
    public Note findByUserId(long userId) {
        return null;
    }

    @Override
    public Note findByTitle(String title) {
        return null;
    }

    @Override
    public Note save(Note note) {
        return null;
    }

    @Override
    public List<Note> findAll() {
        return null;
    }

    @Override
    public void deleteById(long id) {

    }
}
