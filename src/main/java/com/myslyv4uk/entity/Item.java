package com.myslyv4uk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEMS")
public class Item {

    @Id
    @Column(name = "item_id", unique = true, nullable = false)
    private Integer itemId;

}
