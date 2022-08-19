package com.code.miraz.configuration;


import com.techprimers.grpc.MahasiswaServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ManagedChannelConfiguration {

    @Bean
    public ManagedChannel managedChannel(){
        return ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    @Bean
    public MahasiswaServiceGrpc.MahasiswaServiceBlockingStub mahasiswaServiceBlockingStub(){
        return MahasiswaServiceGrpc.newBlockingStub(managedChannel());
    }
}