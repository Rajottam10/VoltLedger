package io.voltledger.userservice.services.grpc;

import io.grpc.stub.StreamObserver;
import io.voltledger.proto.user.GetUserByEmailRequest;
import io.voltledger.proto.user.UserResponse;
import io.voltledger.proto.user.UserServiceGrpc;
import io.voltledger.userservice.entities.Users;
import io.voltledger.userservice.services.UserService;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    private final UserService userService;

    public UserGrpcService(UserService userService){
        this.userService = userService;
    }

    @Override
    public void getUserByEmail(GetUserByEmailRequest request, StreamObserver<UserResponse> responseObserver){
        Users user = userService.findByEmail(request.getEmail());

        UserResponse userResponse = UserResponse.newBuilder()
                .setId(user.getId())
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setEmail(user.getEmail())
                .setRole(user.getRole().getName())
                .setStatus(user.getStatus().getName())
                .build();
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();
    }
}
