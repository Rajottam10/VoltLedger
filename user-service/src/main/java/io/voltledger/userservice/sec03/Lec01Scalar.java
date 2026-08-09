//package io.voltledger.userservice.sec03;
//
//import io.voltledger.userservice.models.sec03.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Lec01Scalar {
//    private static final Logger log = LoggerFactory.getLogger(Lec01Scalar.class);
//
//    public static void main(String[] args) {
//        var user3 = User.newBuilder()
//                .setLastName("Parker")
//                .setAge(30)
//                .setEmail("parker@gmail.com")
//                .setEmployed(true)
//                .setSalary(40000.56)
//                .setBankAccountNumber(123456435)
//                .setBalance(-10000)
//                .build();
//        log.info("== {}", user3);
//    }
//}
