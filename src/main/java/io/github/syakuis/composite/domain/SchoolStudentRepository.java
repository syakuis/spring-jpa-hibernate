package io.github.syakuis.composite.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-02
 */
//public interface SchoolStudentRepository extends CrudRepository<SchoolStudentEntity, IdOfSchoolAndStudent> {
public interface SchoolStudentRepository extends CrudRepository<SchoolStudentEntity, Long> {
    List<SchoolStudentEntity> findBySchoolId(Long schoolId);
}
