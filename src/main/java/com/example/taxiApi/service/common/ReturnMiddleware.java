package com.example.taxiApi.service.common;

import com.example.taxiApi.service.common.dto.ReturnJSONUtilDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnMiddleware {
    private final ObjectMapper objectMapper;
    public ResponseEntity<String> returnMiddleware(ReturnJSONUtilDto result) {
        try {
            String json = objectMapper.writeValueAsString(result);
            return ResponseEntity.ok(json);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
