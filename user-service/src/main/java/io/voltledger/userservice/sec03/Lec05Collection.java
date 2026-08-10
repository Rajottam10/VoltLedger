//package io.voltledger.userservice.sec03;
//
//import io.voltledger.userservice.models.sec03.BodyStyle;
//import io.voltledger.userservice.models.sec03.Book;
//import io.voltledger.userservice.models.sec03.Library;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.util.List;
//
//public class Lec05Collection {
//
//    private static final Logger log = LoggerFactory.getLogger(Lec05Collection.class);
//
//    public static void main(String[] args) {
//        var book1 = Book.newBuilder()
//                .setTitle("48 Laws of Power")
//                .setAuthor("Robert Greene")
//                .setPublicationYear(2004)
//                .setBodyStyle(BodyStyle.NONFICTION)
//                .build();
//        var book2 = book1.toBuilder().setTitle("The Laws of Human Nature").setPublicationYear(2005).build();
//        var book3= book1.toBuilder().setTitle("The Laws of Seduction").setPublicationYear(2006).build();
//
//        var library = Library.newBuilder()
//                .setName("Bibliothek")
//                .addBooks(book1)
//                .addBooks(book2)
//                .addAllBooks(List.of(book1, book2, book3))
//                .build();
//        log.info("{}", library);
//    }
//}
