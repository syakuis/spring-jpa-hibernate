package io.github.syakuis.composite.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Seok Kyun. Choi.
 * @since 2022-06-02
 */

@DataJpaTest
class SchoolRepositoryTest {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void save() {
        SchoolEntity actual = schoolRepository.save(SchoolEntity.builder().name("어떤학교").build());
        SchoolEntity expected = schoolRepository.findById(actual.getId()).orElseThrow();

        assertEquals(expected, actual);
    }
}