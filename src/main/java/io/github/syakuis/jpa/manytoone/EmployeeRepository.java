package io.github.syakuis.jpa.manytoone;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-07
 */
public interface EmployeeRepository extends Repository<EmployeeEntity, Long> {
    EmployeeEntity save(EmployeeEntity employeeEntity);
    @EntityGraph(attributePaths = "department")
    List<EmployeeEntity> findAll();
    EmployeeEntity findById(long id);
    @Query("select e from EmployeeEntity e join fetch e.department ")
    List<EmployeeEntity> fetch();
}
