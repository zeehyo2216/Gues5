package com.example.gues5.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRegi {

    @NotEmpty(message = "이메일은 필수값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
            message = "유효하지 않은 이메일 형식입니다.")
    private String email;

    private String password;
    private String nickname;

}
