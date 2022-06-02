package io.github.syakuis.api.sample.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "id")
@ToString
@Entity
@Table(name = "sample")
public class SampleEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime creationDatetime;

    @Builder
    public SampleEntity(String name) {
        this.name = name;
    }

    public void delete() {
        this.deleted = true;
    }

}
