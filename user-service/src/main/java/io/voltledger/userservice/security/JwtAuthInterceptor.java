//package io.voltledger.userservice.security;
//
//import io.grpc.*;
//import io.jsonwebtoken.Claims;
//import org.springframework.grpc.server.GlobalServerInterceptor;
//import org.springframework.stereotype.Component;
//
//import java.util.Set;
//
//@Component
//@GlobalServerInterceptor
//public class JwtAuthInterceptor implements ServerInterceptor {
//
//    private static final Metadata.Key<String> AUTH_HEADER =
//            Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
//
//    private static final Set<String> PUBLIC_METHODS = Set.of(
//            "voltledger.user.UserService/Login"
//    );
//
//    private final JwtUtil jwtUtil;
//
//    public JwtAuthInterceptor(JwtUtil jwtUtil) {
//        this.jwtUtil = jwtUtil;
//    }
//
//    @Override
//    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
//            ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {
//
//        String fullMethodName = call.getMethodDescriptor().getFullMethodName();
//
//        if (PUBLIC_METHODS.contains(fullMethodName)) {
//            return next.startCall(call, headers);
//        }
//
//        String authHeader = headers.get(AUTH_HEADER);
//        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//            call.close(Status.UNAUTHENTICATED.withDescription("Missing bearer token"), headers);
//            return new ServerCall.Listener<>() {};
//        }
//
//        try {
//            String token = authHeader.substring(7);
//            Claims claims = jwtUtil.parseToken(token);
//
//            CallerPrincipal principal = new CallerPrincipal(
//                    claims.get("userId", Long.class),
//                    claims.getSubject(),
//                    claims.get("userType", String.class)
//            );
//
//            Context context = Context.current().withValue(CallerContext.CALLER, principal);
//            return Contexts.interceptCall(context, call, headers, next);
//
//        } catch (Exception e) {
//            call.close(Status.UNAUTHENTICATED.withDescription("Invalid token"), headers);
//            return new ServerCall.Listener<>() {};
//        }
//    }
//}