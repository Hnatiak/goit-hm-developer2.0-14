package org.example.todoapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.todoapp.model.Note;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    private final Map<Long, Note> notes = new HashMap<>();
    private long nextId = 1;

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    public Note add(Note note) {
        note.setId(nextId++);
        notes.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note not found");
        }
        notes.remove(id);
    }

    public void update(Note note) {
        Note existing = notes.get(note.getId());

        if (existing == null) {
            throw new RuntimeException("Note not found");
        }

        existing.setTitle(note.getTitle());
        existing.setContent(note.getContent());
    }

    public Note getById(long id) {
        Note note = notes.get(id);

        if (note == null) {
            throw new RuntimeException("Note not found");
        }

        return note;
    }
}