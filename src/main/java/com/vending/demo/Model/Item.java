package com.vending.demo.Model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Item {

    @Id
    private Long itemId;
    private String itemName;
    private int Qty;
    private Float price;

    public Item(String itemName, int qty, Float price) {
        this.itemName = itemName;
        Qty = qty;
        this.price = price;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
