package io.voltledger.userservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Status extends BaseEntity{
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(15)")
    private String name;

    @Column(name = "description", nullable = false)
    private String description;
}
