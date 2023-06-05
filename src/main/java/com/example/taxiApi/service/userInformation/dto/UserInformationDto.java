package com.example.taxiApi.service.userInformation.dto;

import com.example.taxiApi.entity.DrivingRecord;
import com.example.taxiApi.entity.TaxiReserve;
import com.example.taxiApi.entity.UserInformation;
import com.example.taxiApi.entity.UserPayment;
import com.example.taxiApi.service.common.EmailMaskingUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformationDto {
    private Long id;
    private String userEmail;
    private String phone;
    private String nickname;
    private String language;
    private LocalDateTime registerDateTime;
    private LocalDateTime updateDateTime;
    private String userPassword;
    private List<TaxiReserve> taxiReserveList;
    private List<DrivingRecord> drivingRecordList;
    private List<UserPayment> userPaymentList;

    public UserInformationDto EntityToDto(UserInformation userInformation) {
        UserInformationDto dto = new UserInformationDto();
        dto.id = userInformation.getId();
        dto.userEmail = EmailMaskingUtil.maskUserEmail(userInformation.getUserEmail());
        dto.phone = userInformation.getPhone();
        dto.nickname = userInformation.getNickname();
        dto.language = userInformation.getLanguage();
        dto.userPassword = userInformation.getUserPassword();
        dto.registerDateTime = userInformation.getRegisterDateTime();
        dto.updateDateTime = userInformation.getUpdateDateTime();
        dto.taxiReserveList = userInformation.getTaxiReserveList();
        dto.drivingRecordList = userInformation.getDrivingRecordList();
        dto.userPaymentList = userInformation.getUserPaymentList();
        return dto;
    }
}
