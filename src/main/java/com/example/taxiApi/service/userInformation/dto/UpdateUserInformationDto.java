package com.example.taxiApi.service.userInformation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "회원수정")
public class UpdateUserInformationDto {
    @Schema(description = "사용자 식별번호")
    private Long id;
    @Schema(description = "이메일", example = "abc@gmail.com")
    private String userEmail;
    @Schema(description = "전화번호", nullable = true, example = "010-0000-0000")
    private String phone;
    @Schema(description = "닉네임", nullable = true)
    private String nickname;
    @Schema(description = "사용자 언어", example = "KO")
    private String language;
    @Schema(description = "비밀번호")
    private String userPassword;
}
