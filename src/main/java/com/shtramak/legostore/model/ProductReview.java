package com.shtramak.legostore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductReview {
    private String userName;
    private int rating;
}
