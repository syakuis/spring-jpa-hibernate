package io.github.syakuis.composite.domain;

import lombok.*;

import javax.persistence.*;

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

    @EmbeddedId
    private IdOfSchoolAndStudent id;

    @MapsId("schoolId")
    @ManyToOne
    @JoinColumn(name = "school_id")
    private SchoolEntity school;

    @MapsId("studentId")
    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity student;

    @Builder
    public SchoolStudentEntity(SchoolEntity school, StudentEntity student) {
        this.school = school;
        this.student = student;
    }
}
