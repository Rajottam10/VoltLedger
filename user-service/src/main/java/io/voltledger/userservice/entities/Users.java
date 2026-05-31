package io.voltledger.userservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Users extends BaseEntity{
    private String name;
    private String email;
    private String password;
    @ManyToOne
    private Roles role;
    private Long mobileNumber;
    private String address;
    @OneToOne
    private Status status;
    private boolean isSuperAdmin;
}
