package io.github.syakuis.jpa.manytoone;

import org.springframework.data.repository.Repository;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-07
 */
public interface DepartmentRepository extends Repository<DepartmentEntity, Long> {
    DepartmentEntity save(DepartmentEntity departmentEntity);
}
