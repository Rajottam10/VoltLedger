//package io.voltledger.propertyservice.controllers;
//
//import io.voltledger.proto.user.GetUserByEmailRequest;
//import io.voltledger.proto.user.UserResponse;
//import io.voltledger.proto.user.UserServiceGrpc;
//import org.springframework.grpc.client.GrpcChannelFactory;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class UserLookupController {
//
//    private final UserServiceGrpc.UserServiceBlockingStub userServiceStub;
//
//    public UserLookupController(GrpcChannelFactory channels) {
//        this.userServiceStub = UserServiceGrpc.newBlockingStub(channels.createChannel("user-service"));
//    }
//
//    @GetMapping("/test/user/{email}")
//    public String getUser(@PathVariable String email) {
//        GetUserByEmailRequest request = GetUserByEmailRequest.newBuilder()
//                .setEmail(email)
//                .build();
//
//        UserResponse response = userServiceStub.getUserByEmail(request);
//        return response.toString();
//    }
//}
