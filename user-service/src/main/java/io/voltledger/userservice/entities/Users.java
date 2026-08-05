package io.voltledger.userservice.entities;

import io.voltledger.userservice.enums.UserType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class Users extends BaseEntity{
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

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

    @Column(name = "user_type", columnDefinition = "VARCHAR(10)")
    @Enumerated(EnumType.STRING)
    private UserType userType;

    //todo : why ManyToOne was used? what and why is fetch and cascade used? what does JoinColumn do?
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Status status;
}
