package io.github.syakuis.composite.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-02
 */

@Slf4j
@DataJpaTest
class SchoolJoinStudentRepositoryTest {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolStudentRepository schoolStudentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void join() {
        SchoolEntity school = schoolRepository.save(SchoolEntity.builder().name("어떤학교").build());
        StudentEntity student = studentRepository.save(StudentEntity.builder().name("홍길동").build());

        SchoolStudentEntity schoolStudentEntity = SchoolStudentEntity.builder().school(school).student(student).build();

        schoolStudentRepository.save(schoolStudentEntity);

        SchoolStudentEntity expected = schoolStudentRepository.findById(schoolStudentEntity.getId()).orElseThrow();

        log.debug("{}", expected.getSchool());
    }
}