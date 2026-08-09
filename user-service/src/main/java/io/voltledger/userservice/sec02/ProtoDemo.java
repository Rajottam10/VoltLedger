//package io.voltledger.userservice.sec02;
//
//import io.voltledger.userservice.models.sec02.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class ProtoDemo {
//    private static final Logger log = LoggerFactory.getLogger(ProtoDemo.class);
//
//    public static void main(String[] args) {
//        var user1 = createUser();
//        var user2 = createUser();
//
//        //compare
//        log.info("equals {}",user1.equals(user2));
//        log.info("== {}",(user1 == user2));
//
//        //mutable? NO
//
//        //create another instance with diff values
//        var user3 = user1.toBuilder().setName("Ned").build();
//        log.info("== {}", user3);
//
//        //compare
//        log.info("equals {}",user1.equals(user3));
//        log.info("== {}",(user1 == user3));
//
//        //null?
//        var user4 = user1.toBuilder().clearName().build();
//        log.info("user4: {}", user4);
//    }
//
//    private static User createUser(){
//        return User.newBuilder()
//                .setName("Peter")
//                .setAge(30)
//                .build();
//    }
//}
