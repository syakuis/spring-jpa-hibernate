package io.github.syakuis.composite.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-02
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
@Embeddable
public class IdOfSchoolAndStudent implements Serializable {
    @Column(nullable = false, updatable = false)
    private Long schoolId;
    @Column(nullable = false, updatable = false)
    private Long studentId;

    @Builder
    public IdOfSchoolAndStudent(Long schoolId, Long studentId) {
        this.schoolId = schoolId;
        this.studentId = studentId;
    }
}
