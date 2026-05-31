package io.voltledger.userservice.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Roles extends BaseEntity{
    private String name;
    private String description;
}
