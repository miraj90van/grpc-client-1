package com.code.miraz.controller;

import com.code.miraz.services.MahasiswaGrpcClientService;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import com.techprimers.grpc.MahasiswaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MahasiswaController {

    @Autowired
    private MahasiswaGrpcClientService mahasiswaGrpcClientService;

    @RequestMapping(value = "/test_grpc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test(@RequestParam(value = "compact", required = false, defaultValue = "false") boolean compact) {

        MahasiswaResponse mahasiswaResponse = mahasiswaGrpcClientService.getMahasiswaRequest();
        if (compact) {
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {

            String jsonString = "";
            try {
                jsonString = JsonFormat.printer().print(mahasiswaResponse);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
            return new ResponseEntity<>(jsonString, HttpStatus.OK);
        }
    }
}