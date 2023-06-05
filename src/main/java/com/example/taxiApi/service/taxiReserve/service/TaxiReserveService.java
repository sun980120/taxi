package com.example.taxiApi.service.taxiReserve.service;


import com.example.taxiApi.entity.TaxiReserve;
import com.example.taxiApi.service.taxiReserve.dto.TaxiReserveDto;

public interface TaxiReserveService {
    TaxiReserve saveTaxiReserving(TaxiReserveDto taxiReserve);
}
