package com.example.repositories;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

public class DynamoDbRepository {
    private static final String TABLE_NAME = "FitLog_Activities";
    private final DynamoDbClient ddb;

    // Konstruktor som tar en DynamoDbClient som parameter
    public DynamoDbRepository(DynamoDbClient ddb) {
        this.ddb = ddb;
    }

    // Skapa en aktivitet i DynamoDB
    public void createActivity(String id, String type, int duration) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", AttributeValue.builder().s(id).build());
        item.put("type", AttributeValue.builder().s(type).build());
        item.put("duration", AttributeValue.builder().n(String.valueOf(duration)).build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName(TABLE_NAME)
                .item(item)
                .build();

        ddb.putItem(request);
        System.out.println("Lagt till aktivitet i DynamoDB: " + id);
    }

    // Hämta en aktivitet från DynamoDB
    public Map<String, AttributeValue> getActivity(String id) {
        GetItemRequest request = GetItemRequest.builder()
                .tableName(TABLE_NAME)
                .key(Map.of("id", AttributeValue.builder().s(id).build()))
                .build();

        GetItemResponse response = ddb.getItem(request);
        return response.item();
    }
}
