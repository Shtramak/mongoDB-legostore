package com.shtramak.legostore.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class DeliveryInfo {
    private LocalDate deliveryDate;
    private BigDecimal deliveryFee;
    private boolean inStock;
}
