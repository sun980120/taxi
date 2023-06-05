package com.example.taxiApi.service.userInformation;

import com.example.taxiApi.service.common.ReturnMiddleware;
import com.example.taxiApi.service.common.dto.ReturnJSONUtilDto;
import com.example.taxiApi.service.userInformation.dto.InsertUserInformationDto;
import com.example.taxiApi.service.userInformation.dto.UpdateUserInformationDto;
import com.example.taxiApi.service.userInformation.service.UserInformationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "UserInformation", description = "회원관리 API")
@RestController
@RequestMapping("/v1/member-manage")
@RequiredArgsConstructor
public class UserInformationController {

    private final UserInformationService userInformationService;

    private final ReturnMiddleware returnMiddleware;
    @Operation(summary = "회원가입", description = "사용자가 입력한 정보를 저장한다.", responses = {
            @ApiResponse(responseCode = "200", description = "회원 정보 추가", content = @Content(schema = @Schema(implementation = ReturnJSONUtilDto.class)))
    })
    @PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUserInformation(@RequestBody InsertUserInformationDto insertUserInformationDto) {
        return returnMiddleware.returnMiddleware(userInformationService.saveUserInformation(insertUserInformationDto));
    }

    @Operation(summary = "회원수정", description = "사용자가 입력한 정보를 수정한다.", responses = {
            @ApiResponse(responseCode = "200", description = "회원 정보 수정", content = @Content(schema = @Schema(implementation = ReturnJSONUtilDto.class)))
    })
    @PostMapping(value = "/update/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUserInformation(@Parameter(name = "type", description = "0: 프로필변경 / 1: 비밀번호변경", in = ParameterIn.PATH) @PathVariable int type, @RequestBody UpdateUserInformationDto updateUserInformationDto) {
        return returnMiddleware.returnMiddleware(userInformationService.updateUserInformation(updateUserInformationDto, type));
    }

    @Operation(summary = "회원탈퇴", description = "사용자의 정보를 삭제한다.", responses = {
            @ApiResponse(responseCode = "200", description = "회원 정보 삭제", content = @Content(schema = @Schema(implementation = ReturnJSONUtilDto.class)))
    })
    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUserInformation(@Parameter(name = "id", description = "사용자의 id", in = ParameterIn.PATH) @PathVariable Long id) {
        return returnMiddleware.returnMiddleware(userInformationService.deleteUserInformation(id));
    }
}
