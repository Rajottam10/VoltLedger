//package io.voltledger.userservice.sec03;
//
//import io.voltledger.userservice.models.sec03.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//
//public class Lec02Serialization {
//    private static final Logger log = LoggerFactory.getLogger(Lec02Serialization.class);
//    private static final Path PATH = Path.of("user.out");
//
//    public static void main(String[] args) throws IOException {
//        var user = User.newBuilder()
//                .setLastName("Parker")
//                .setAge(30)
//                .setEmail("parker@gmail.com")
//                .setEmployed(true)
//                .setSalary(40000.56)
//                .setBankAccountNumber(123456435)
//                .setBalance(-10000)
//                .build();
//        serialize(user);
//        log.info("{}", deserialize());
//        log.info("{}",user.equals(deserialize()));
//        log.info("bytes length: {}", user.toByteArray().length);
//    }
//
//    public static void serialize(User user) throws IOException {
//        try(var stream = Files.newOutputStream(PATH)){
//            user.writeTo(stream);
//        }
//    }
//
//    public static User deserialize() throws IOException{
//        try(var stream = Files.newInputStream(PATH)){
//            return User.parseFrom(stream);
//        }
////        return User.parseFrom(Files.newInputStream(PATH));
//    }
//}
