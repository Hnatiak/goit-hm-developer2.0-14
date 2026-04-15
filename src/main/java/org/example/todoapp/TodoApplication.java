// package org.example;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class TodoApplication {

//     public static void main(String[] args) {
//         SpringApplication.run(TodoApplication.class, args);
//     }
// }


package org.example.todoapp;

import jakarta.annotation.PostConstruct;
import org.example.todoapp.model.Note;
import org.example.todoapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

    @Autowired
    private NoteService noteService;

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class, args);
    }

    @PostConstruct
    public void test() {
        Note note = new Note();
        note.setTitle("Test");
        note.setContent("Hello");

        Note saved = noteService.add(note);

        System.out.println("Created: " + saved.getId());

        System.out.println("All notes: " + noteService.listAll());
    }
}
