package com.example.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "section")

public class Section {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "section")
    @ToString.Exclude
    private Set<Note> notes;
    @Column(name = "createdate")
    private Date createDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Section section = (Section) o;
        return id != null && Objects.equals(id, section.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
