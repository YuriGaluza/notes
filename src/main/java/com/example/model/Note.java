package com.example.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "note")

public class Note {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "content")
    private String content;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "note")
    private Set<Grade> grades;
    @Column(name = "archive")
    private Boolean isArchive;
    @OneToMany(mappedBy = "note")
    private List<Comment> comments;
    @Column(name = "version")
    private Integer version;

    @Transient
    private float rating;

    public Note() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Grade> getGrades() {
        return grades;
    }

    public void setGrades(Set<Grade> grades) {
        this.grades = grades;
    }

    public Boolean getArchive() {
        return isArchive;
    }

    public void setArchive(Boolean archive) {
        isArchive = archive;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public float getRating() {
        if (grades != null && grades.size() != 0) {
            rating = 1.0f * sumGrades(grades) / grades.size();
            return rating;
        }
        return 0f;
    }

    private int sumGrades(Set<Grade> grades) {
        int sum = 0;
        for (Grade grade : grades) {
            sum += grade.getValue();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note note)) return false;

        if (Float.compare(note.getRating(), getRating()) != 0) return false;
        if (getId() != null ? !getId().equals(note.getId()) : note.getId() != null) return false;
        if (getName() != null ? !getName().equals(note.getName()) : note.getName() != null) return false;
        if (getContent() != null ? !getContent().equals(note.getContent()) : note.getContent() != null) return false;
        if (getSection() != null ? !getSection().equals(note.getSection()) : note.getSection() != null) return false;
        if (getUser() != null ? !getUser().equals(note.getUser()) : note.getUser() != null) return false;
        if (getGrades() != null ? !getGrades().equals(note.getGrades()) : note.getGrades() != null) return false;
        if (isArchive != null ? !isArchive.equals(note.isArchive) : note.isArchive != null) return false;
        if (getComments() != null ? !getComments().equals(note.getComments()) : note.getComments() != null)
            return false;
        return getVersion() != null ? getVersion().equals(note.getVersion()) : note.getVersion() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        result = 31 * result + (getSection() != null ? getSection().hashCode() : 0);
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        result = 31 * result + (getGrades() != null ? getGrades().hashCode() : 0);
        result = 31 * result + (isArchive != null ? isArchive.hashCode() : 0);
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        result = 31 * result + (getVersion() != null ? getVersion().hashCode() : 0);
        result = 31 * result + (getRating() != 0.0f ? Float.floatToIntBits(getRating()) : 0);
        return result;
    }
}
