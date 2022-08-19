package com.code.miraz.services;

import com.techprimers.grpc.MahasiswaRequest;
import com.techprimers.grpc.MahasiswaResponse;
import com.techprimers.grpc.MahasiswaServiceGrpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaGrpcClientService {

    @Autowired
    private MahasiswaServiceGrpc.MahasiswaServiceBlockingStub mahasiswaServiceBlockingStub;

    public MahasiswaResponse getMahasiswaRequest(){

        MahasiswaRequest mahasiswaRequest = MahasiswaRequest.newBuilder()
                .setNim("Nim-100001")
                .setName("Muhammad Miraj")
                .build();

        return mahasiswaServiceBlockingStub.getMahasiswa(mahasiswaRequest);
    }
}