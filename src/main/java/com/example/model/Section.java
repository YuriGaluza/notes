package com.example.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "section")

public class Section {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", unique = true)
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "section")
    private Set<Note> notes;
    @Column(name = "createdate")
    private Date createDate;

    public Section() {
    }

    public Section(Long id, String name, User user, Set<Note> notes, Date createDate) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.notes = notes;
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

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
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
        if (!(o instanceof Section)) return false;

        Section section = (Section) o;

        if (getId() != null ? !getId().equals(section.getId()) : section.getId() != null) return false;
        if (getName() != null ? !getName().equals(section.getName()) : section.getName() != null) return false;
        if (getUser() != null ? !getUser().equals(section.getUser()) : section.getUser() != null) return false;
        if (getNotes() != null ? !getNotes().equals(section.getNotes()) : section.getNotes() != null) return false;
        return getCreateDate() != null ? getCreateDate().equals(section.getCreateDate()) : section.getCreateDate() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getNotes() != null ? getNotes().hashCode() : 0);
        result = 31 * result + (getCreateDate() != null ? getCreateDate().hashCode() : 0);
        return result;
    }
}
