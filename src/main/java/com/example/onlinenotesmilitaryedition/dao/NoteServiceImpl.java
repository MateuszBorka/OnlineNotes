package com.example.onlinenotesmilitaryedition.dao;

import com.example.onlinenotesmilitaryedition.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService{

    private final NoteDao noteDao;
    @Autowired
    public NoteServiceImpl(NoteDao noteDao){
        this.noteDao = noteDao;
    }

    @Override
    public Note findByUserId(long userId) {
        return null;
    }

    @Override
    public Note findById(long id) {
        return noteDao.findById(id);
    }

    @Override
    public void save(Note note) {
        noteDao.save(note);
    }

    @Override
    public List<Note> findAllByUserId(long userId){
        return noteDao.findAllByUserId(userId);
    }

    @Override
    public void deleteById(long id) {
        noteDao.deleteById(id);
    }
}
