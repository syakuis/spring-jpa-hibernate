package io.github.syakuis.composite.domain;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-02
 */
public interface StudentRepository extends CrudRepository<StudentEntity, Long> {
}
