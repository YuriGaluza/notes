package com.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "grade")

public class Grade {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "value")
    private Integer value;
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    public Grade() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade grade)) return false;

        if (getId() != null ? !getId().equals(grade.getId()) : grade.getId() != null) return false;
        if (getValue() != null ? !getValue().equals(grade.getValue()) : grade.getValue() != null) return false;
        return getNote() != null ? getNote().equals(grade.getNote()) : grade.getNote() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
        return result;
    }
}
