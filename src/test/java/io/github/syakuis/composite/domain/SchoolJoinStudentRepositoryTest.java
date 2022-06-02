package io.github.syakuis.composite.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    private SchoolEntity schoolEntity;

    @BeforeEach
    void init() {
        this.schoolEntity = schoolRepository.save(SchoolEntity.builder().name("홍씨학교").build());

        schoolStudentRepository.save(SchoolStudentEntity.builder()
            .school(schoolEntity)
            .student(studentRepository.save(StudentEntity.builder().name("홍길동").build())).build());

        schoolStudentRepository.save(SchoolStudentEntity.builder()
            .school(schoolEntity)
            .student(studentRepository.save(StudentEntity.builder().name("홍삼이").build())).build());

        schoolStudentRepository.save(SchoolStudentEntity.builder()
            .school(schoolEntity)
            .student(studentRepository.save(StudentEntity.builder().name("홍두식").build())).build());

        entityManager.flush();
        entityManager.clear();
    }

    @DisplayName("학교와 학생을 모두 조회한다.")
    @Test
    void joinSchoolStudent() {
        List<SchoolStudentEntity> expected = schoolStudentRepository.findBySchoolId(schoolEntity.getId());

        expected.forEach(it -> {
            log.debug("{}", it.getStudent());
        });

//        assertNotNull(expected);

//        assertEquals(expected.getStudent().getName(), studentEntity.getName());
//        assertEquals(expected.getSchool().getName(), schoolEntity.getName());
    }
}