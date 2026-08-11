package io.voltledger.propertyservice.service;

import io.grpc.stub.StreamObserver;
import io.voltledger.proto.javatechie.StockRequest;
import io.voltledger.proto.javatechie.StockResponse;
import io.voltledger.proto.javatechie.StockTradingServiceGrpc;
import org.springframework.stereotype.Service;
import net.devh.boot.grpc.client.inject.GrpcClient;

import java.sql.SQLOutput;

@Service
public class StockClientService {

//    @GrpcClient("stockServiceOne")
//    private StockTradingServiceGrpc.StockTradingServiceBlockingStub serviceBlockingStub;

    @GrpcClient("stockService")
    private StockTradingServiceGrpc.StockTradingServiceStub stockTradingServiceStub;

//    public StockResponse getStockPrice(String stockSymbol){
//        StockRequest stockRequest = StockRequest.newBuilder().setStockSymbol(stockSymbol).build();
//        return serviceBlockingStub.getStockPrice(stockRequest);
//    }

    public void subscribeStockPrice(String symbol){
        StockRequest request = StockRequest.newBuilder()
                .setStockSymbol(symbol)
                .build();
        stockTradingServiceStub.subscribeStockPrice(request, new StreamObserver<StockResponse>() {
            @Override
            public void onNext(StockResponse stockResponse) {
                System.out.println("Stock price update: "+ stockResponse.getStockSymbol()+ " Price: "+stockResponse.getPrice()+" Time: "+stockResponse.getTimestamp());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Error: "+throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Stock price stream live update completed.");
            }
        });
    }
}
