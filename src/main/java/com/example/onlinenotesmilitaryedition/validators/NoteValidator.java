package com.example.onlinenotesmilitaryedition.validators;

import com.example.onlinenotesmilitaryedition.models.Note;
import org.springframework.validation.Errors;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

@Component
public class NoteValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Note.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Note note = (Note) target;

        if (note.getTitle().isEmpty()) {
            errors.rejectValue("title", "title.empty", "Title cannot be empty");
        }

        if (note.getBody().isEmpty()) {
            errors.rejectValue("body", "body.empty", "Body cannot be empty");
        }
    }
}
