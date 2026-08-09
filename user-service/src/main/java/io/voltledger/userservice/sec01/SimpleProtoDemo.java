//package io.voltledger.userservice.sec01;
//
//import io.voltledger.userservice.models.sec01.UserOuterClass;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class SimpleProtoDemo {
//
//    private static final Logger log = LoggerFactory.getLogger(SimpleProtoDemo.class);
//
//    public static void main(String[] args) {
//        var User = UserOuterClass.User.newBuilder()
//                .setName("Sanjiv")
//                .setAge(37)
//                .build();
//        log.info("{}",User);
//    }
//}
