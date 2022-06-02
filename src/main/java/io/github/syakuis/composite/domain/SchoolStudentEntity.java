package io.github.syakuis.composite.domain;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-02
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity
@Table(name = "school_student")
public class SchoolStudentEntity {

//    @EmbeddedId
//    private IdOfSchoolAndStudent id;
    @Id
    @GeneratedValue
    private Long id;

//    @MapsId("schoolId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "school_id", nullable = false, updatable = false)
    private SchoolEntity school;

//    @MapsId("studentId")
    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", nullable = false, updatable = false)
    private StudentEntity student;

    @Builder
    public SchoolStudentEntity(SchoolEntity school, StudentEntity student) {
        this.school = school;
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SchoolStudentEntity that = (SchoolStudentEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
