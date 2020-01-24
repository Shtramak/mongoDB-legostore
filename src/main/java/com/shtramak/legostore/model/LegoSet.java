package com.shtramak.legostore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
public class LegoSet {
    private String id;
    private String name;
    private LegoSetDifficulty difficulty;
    private String theme;
    private Collection<ProductReview> reviews;
    private DeliveryInfo deliveryInfo;
}
