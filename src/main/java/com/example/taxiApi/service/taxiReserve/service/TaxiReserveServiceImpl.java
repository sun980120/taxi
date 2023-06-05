package com.example.taxiApi.service.taxiReserve.service;

import com.example.taxiApi.entity.TaxiReserve;
import com.example.taxiApi.entity.UserInformation;
import com.example.taxiApi.repository.TaxiReserveRepository;
import com.example.taxiApi.repository.UserInformationRepository;
import com.example.taxiApi.service.common.ArrivalTimeService;
import com.example.taxiApi.service.taxiReserve.dto.TaxiReserveDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
@Transactional
public class TaxiReserveServiceImpl implements TaxiReserveService{
    private final TaxiReserveRepository taxiReserveRepository;
    private final UserInformationRepository userInformationRepository;
    private final ArrivalTimeService arrivalTimeService;
    @Override
    public TaxiReserve saveTaxiReserving(TaxiReserveDto taxiReserve) {
        try {
            UserInformation userInformation = userInformationRepository.findById(taxiReserve.getUserInformationId()).get();
            arrivalTimeService.getArrivalTimeWebClient(taxiReserve).subscribe(result -> {
                System.out.println("도착 예상 시간: " + result);
//                System.out.println();
                }, error -> {
                System.out.println("API 호출 중 오류 발생: " + error.getMessage());
            });
            int t = arrivalTimeService.getArrivalTimeRestTemplate(taxiReserve);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime dateTime = LocalDateTime.parse(taxiReserve.getDepDateTime(), formatter);
//            TaxiReserve result = TaxiReserve.builder();
            System.out.println(t);

            TaxiReserve saveTaxiReserve = TaxiReserve.builder()
                    .arrLocation(taxiReserve.getArrLocation().toString())
                    .depLocation(taxiReserve.getDepLocation().toString())
                    .depDateTime(dateTime)
                    .arrDateTime(dateTime.plusSeconds(t))
                    .userInformation(userInformation)
                    .build();
            taxiReserveRepository.save(saveTaxiReserve);

            return saveTaxiReserve;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
