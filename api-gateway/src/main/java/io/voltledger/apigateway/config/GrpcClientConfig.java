package io.voltledger.apigateway.config;

import io.voltledger.proto.user.UserServiceGrpc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.GrpcChannelFactory;

@Configuration
public class GrpcClientConfig {

    @Bean
    public UserServiceGrpc.UserServiceBlockingStub userServiceStub(GrpcChannelFactory channels){
        return UserServiceGrpc.newBlockingStub(channels.createChannel("user-service"));
    }
}
