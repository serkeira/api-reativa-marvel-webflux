package com.digitalinnovation.livecoding.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import lombok.*;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName ="Heroes_Api_Table")
@Getter
@Setter
@AllArgsConstructor
public class Hero {

  @Id
  @DynamoDBHashKey (attributeName = "id")
  private String id;

  @DynamoDBAttribute (attributeName = "name")
  private String name;

  @DynamoDBAttribute (attributeName = "universe")
  private String universe;

  @DynamoDBAttribute (attributeName = "movies")
  private int movies;


}

