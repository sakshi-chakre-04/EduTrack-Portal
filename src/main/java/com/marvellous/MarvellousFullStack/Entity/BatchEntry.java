package com.marvellous.MarvellousFullStack.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "BatchDetails")
@Getter
@Setter
@JsonIgnoreProperties(value = {"id"}, allowGetters = true)
public class BatchEntry
{
    private ObjectId id;
    private String name;
    private int fees;
}
