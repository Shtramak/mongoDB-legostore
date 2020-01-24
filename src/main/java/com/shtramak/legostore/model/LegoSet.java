package com.shtramak.legostore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@Document(collection = "legosets")
public class LegoSet {
    @Id
    private String id;
    private String name;
    private LegoSetDifficulty difficulty;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String theme;
    private Collection<ProductReview> reviews;
    @Field(name = "delivery")
    private DeliveryInfo deliveryInfo;
    @Transient
    private int nbParts;
}
