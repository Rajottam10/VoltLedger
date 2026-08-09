package io.voltledger.userservice.grpc;

import io.grpc.stub.StreamObserver;
import io.voltledger.proto.user.GetUserByEmailRequest;
import io.voltledger.proto.user.UserResponse;
import io.voltledger.proto.user.UserServiceGrpc;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void getUserByEmail(GetUserByEmailRequest request, StreamObserver<UserResponse> responseObserver){
        UserResponse response = UserResponse.newBuilder()
                .setId(1L)
                .setFirstName("Ibrahim")
                .setLastName("Mbaye")
                .setEmail(request.getEmail())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
