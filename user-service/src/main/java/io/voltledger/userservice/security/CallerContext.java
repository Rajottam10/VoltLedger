package io.voltledger.userservice.security;

import io.grpc.Context;

public class CallerContext {
    public static final Context.Key<CallerPrincipal> CALLER = Context.key("caller");
}