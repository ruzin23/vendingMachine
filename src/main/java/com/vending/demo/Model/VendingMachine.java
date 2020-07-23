package com.vending.demo.Model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VendingMachine {


    @Id
    private Long machineId;
    private int coins;

    public VendingMachine(Long id,int coins) {
        this.coins = coins;
    }


    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
