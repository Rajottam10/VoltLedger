package io.voltledger.propertyservice;

import io.voltledger.propertyservice.service.StockClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropertyServiceApplication implements CommandLineRunner {

    private final StockClientService stockClientService;

    public PropertyServiceApplication(StockClientService stockClientService) {
        this.stockClientService = stockClientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(PropertyServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Grpc client response " +stockClientService.getStockPrice("NIFRA"));
        stockClientService.subscribeStockPrice("UPPER");
    }
}
