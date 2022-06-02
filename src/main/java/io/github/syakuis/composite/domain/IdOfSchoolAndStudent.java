package io.github.syakuis.composite.domain;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-02
 */

@EqualsAndHashCode
@Embeddable
public class IdOfSchoolAndStudent implements Serializable {
    @Column
    private Long schoolId;

    @Column
    private Long studentId;
}
