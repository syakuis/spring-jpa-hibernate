package io.github.syakuis.jpa.manytoone;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-08
 */
@Slf4j
@DataJpaTest
class BasicEmployRepositoryTest {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void init() {
        DepartmentEntity departmentEntity = departmentRepository.save(DepartmentEntity.builder()
                .name("부서")
            .build());

        employeeRepository.save(EmployeeEntity.builder()
                .name("홍길동")
                .department(departmentEntity)
            .build());

        employeeRepository.save(EmployeeEntity.builder()
            .name("성춘향")
            .department(departmentEntity)
            .build());

        // 캐시 비우기 (캐시를 비워야 영속성에 저장된 데이터를 사용하지 않고 쿼리를 실행할 수 있다)
        entityManager.clear();
    }

    @Test
    void findById() {
        employeeRepository.findById(1);
    }

    @Test
    void findAll() {
        employeeRepository.findAll();
    }

    @Test
    void findAllAndDepartment() {
        employeeRepository.findAll().forEach(it -> {
            log.debug("{}", it.getDepartment().getName());
        });
    }

    @Test
    void fetchHibernate() {
        entityManager.createQuery("""
            select e
            from EmployeeEntity e
            join fetch e.department
            """, EmployeeEntity.class).getResultList();
    }

    @Test
    void fetchJpa1() {
        employeeRepository.fetch();
    }
}