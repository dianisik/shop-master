package com.example.shop.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Sales {

    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Products nameSales;

    @ManyToOne (fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Clients clientSales;

    private int amountSales;

    private int sumSales;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Shop shopSales;

}
