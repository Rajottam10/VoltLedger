package io.voltledger.userservice.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Users extends BaseEntity{
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    private Roles role;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "address")
    private String address;

    //todo : why ManyToOne was used? what and why is fetch and cascase used? what does JoinColumn do?
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Status status;
    private boolean isSuperAdmin;
}
