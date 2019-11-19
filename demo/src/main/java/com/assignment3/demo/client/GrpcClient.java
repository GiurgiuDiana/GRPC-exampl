package com.assignment3.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8008)

                .usePlaintext()

                .build();


        HelloServiceGrpc.HelloServiceBlockingStub stub

                = HelloServiceGrpc.newBlockingStub(channel);


        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()

                .setFirstName("Baeldung")

                .setLastName("gRPC")

                .build());


        System.out.println("Response received from server:\n" + helloResponse);


        channel.shutdown();

    }

}