package com.example.model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class NoteTest {

    @Test
    public void testAverage() {
        float expected = 3.286f;
        float delta = 0.0001f;
        Set<Grade> gradeSet = new HashSet<>();

        Note note = new Note();
        note.setId(0L);

        Grade grade1 = new Grade();
        grade1.setId(1L);
        grade1.setValue(1);
        grade1.setNote(note);
        gradeSet.add(grade1);

        Grade grade2 = new Grade();
        grade2.setId(2L);
        grade2.setValue(2);
        grade2.setNote(note);
        gradeSet.add(grade2);

        Grade grade3 = new Grade();
        grade3.setId(3L);
        grade3.setValue(3);
        grade3.setNote(note);
        gradeSet.add(grade3);

        Grade grade4 = new Grade();
        grade4.setId(4L);
        grade4.setValue(4);
        grade4.setNote(note);
        gradeSet.add(grade4);

        Grade grade5 = new Grade();
        grade5.setId(5L);
        grade5.setValue(5);
        grade5.setNote(note);
        gradeSet.add(grade5);

        Grade grade6 = new Grade();
        grade6.setId(6L);
        grade6.setValue(3);
        grade6.setNote(note);
        gradeSet.add(grade6);

        Grade grade7 = new Grade();
        grade7.setId(7L);
        grade7.setValue(5);
        grade7.setNote(note);
        gradeSet.add(grade7);

        note.setGrades(gradeSet);

        assertTrue(Math.abs((expected - note.getRating()) / expected) <= delta);
    }

}
