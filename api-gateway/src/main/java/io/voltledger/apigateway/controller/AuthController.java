//package io.voltledger.apigateway.controller;
//
//import io.voltledger.apigateway.dtos.LoginRequestDto;
//import io.voltledger.apigateway.dtos.LoginResponseDto;
//import io.voltledger.proto.user.LoginRequest;
//import io.voltledger.proto.user.LoginResponse;
//import io.voltledger.proto.user.UserServiceGrpc;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    private final UserServiceGrpc.UserServiceBlockingStub userServiceStub;
//
//    public AuthController(UserServiceGrpc.UserServiceBlockingStub userServiceStub){
//        this.userServiceStub = userServiceStub;
//    }
//
//    @PostMapping("/login")
//    public LoginResponseDto login(@RequestBody LoginRequestDto requestDto){
//        LoginRequest grpcRequest = LoginRequest.newBuilder()
//                .setEmail(requestDto.email())
//                .setPassword(requestDto.password())
//                .build();
//
//        LoginResponse grpcResponse = userServiceStub.login(grpcRequest);
//
//        return new LoginResponseDto(grpcResponse.getToken());
//    }
//}
