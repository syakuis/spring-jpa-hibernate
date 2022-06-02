package io.github.syakuis.api.sample.repository;

import io.github.syakuis.api.sample.entity.SampleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepository extends JpaRepository<SampleEntity, Long> {

}
