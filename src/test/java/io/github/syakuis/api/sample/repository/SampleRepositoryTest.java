package io.github.syakuis.api.sample.repository;

import io.github.syakuis.api.sample.entity.SampleEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@ExtendWith(SpringExtension.class)
@DataJpaTest
class SampleRepositoryTest {
    @Autowired
    private SampleRepository sampleRepository;

    @Test
    void test() {
        SampleEntity sampleEntity = sampleRepository.save(
            SampleEntity.builder().name("test").build());

        sampleRepository.flush();

        assertEquals(sampleRepository.findById(sampleEntity.getId()).orElseThrow(), sampleEntity);;
    }
}
