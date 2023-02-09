//package com.podcast_reviews_service.dependency;
//
//import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
//import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import dagger.Module;
//import dagger.Provides;
//
//import javax.inject.Singleton;
//
//@Module
//public class DaoModule {
//
//    @Provides
//    @Singleton
//    public DynamoDBMapper DynamoDBMapper() {
//        return new DynamoDBMapper(DynamoDbClientProvider.getDynamoDBClient(Regions.US_WEST_2));
//    }
//}
