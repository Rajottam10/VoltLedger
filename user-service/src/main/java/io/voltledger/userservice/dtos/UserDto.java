package io.voltledger.userservice.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private Long mobileNumber;
    private String address;
}
