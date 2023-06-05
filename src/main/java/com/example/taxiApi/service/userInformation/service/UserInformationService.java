package com.example.taxiApi.service.userInformation.service;


import com.example.taxiApi.service.common.dto.ReturnJSONUtilDto;
import com.example.taxiApi.service.userInformation.dto.InsertUserInformationDto;
import com.example.taxiApi.service.userInformation.dto.UpdateUserInformationDto;
import com.example.taxiApi.service.userInformation.dto.UserInformationDto;

import java.util.List;

public interface UserInformationService {
    List<UserInformationDto> findAll();

    UserInformationDto findById(Long id);

    ReturnJSONUtilDto saveUserInformation(InsertUserInformationDto insertUserInformationDto);

    ReturnJSONUtilDto updateUserInformation(UpdateUserInformationDto updateUserInformationDto, int type);

    ReturnJSONUtilDto deleteUserInformation(Long id);

    ReturnJSONUtilDto login(UserInformationDto userInformationDto);
}
