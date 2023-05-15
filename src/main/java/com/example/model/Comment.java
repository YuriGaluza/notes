package com.example.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")

public class Comment {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;
    @Column(name = "createdate")
    private Date createDate;

    public Comment() {
    }

    public Comment(Long id, String name, User user, Note note, Date createDate) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.note = note;
        this.createDate = createDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;

        Comment comment = (Comment) o;

        if (getId() != null ? !getId().equals(comment.getId()) : comment.getId() != null) return false;
        if (getName() != null ? !getName().equals(comment.getName()) : comment.getName() != null) return false;
        if (getUser() != null ? !getUser().equals(comment.getUser()) : comment.getUser() != null) return false;
        if (getNote() != null ? !getNote().equals(comment.getNote()) : comment.getNote() != null) return false;
        return getCreateDate() != null ? getCreateDate().equals(comment.getCreateDate()) : comment.getCreateDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getNote() != null ? getNote().hashCode() : 0);
        result = 31 * result + (getCreateDate() != null ? getCreateDate().hashCode() : 0);
        return result;
    }
}
