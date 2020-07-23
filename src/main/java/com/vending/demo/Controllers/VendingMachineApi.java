package com.vending.demo.Controllers;


import com.vending.demo.Model.Item;
import com.vending.demo.Services.InventoryService;
import com.vending.demo.Services.VendingMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
public class VendingMachineApi {

    @Autowired
    VendingMachineService vendingMachineService;

    @Autowired
    InventoryService inventoryService;



    //Add a coin

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity<Void> putCoins(@RequestParam("coin") String name)
            throws URISyntaxException {


              int coins = vendingMachineService.addCoin();

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("X-Coins:",String.valueOf(coins)
                    );
            return ResponseEntity.ok()
                    .headers(responseHeaders).body(null);


    }


    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    public ResponseEntity<Void> returnCoins(@RequestParam int coins)
            throws URISyntaxException {

        if (coins > 2) {
            return ResponseEntity.notFound().build();
        } else {

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Baeldung-Example-Header",
                    "Value-ResponseEntityBuilderWithHttpHeaders");

            return ResponseEntity.ok()
                    .headers(responseHeaders).body(null);

        }
    }




    //Get inventory by Id
    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getInventoryById(@PathVariable("id") Long id)
            throws URISyntaxException {


            int inventoryQty = inventoryService.getItemQtyById(id);
            return ResponseEntity.ok()
                    .body(inventoryQty);


    }



    //Get all inventory

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Integer>> getAllInventory()
            throws URISyntaxException {


        ArrayList<Integer> allInventoryList = inventoryService.getAllInventory();
        return ResponseEntity.ok()
                .body(allInventoryList);

    }




    /**
     * this method takes id of the item
     * @param id
     * @return
     */
    @RequestMapping(value = "/inventory/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> replaceEmployee(@PathVariable Long id) {


        Item item = inventoryService.getItemById(id);
        int coins = vendingMachineService.getCoinsInTheMachine();
         HttpHeaders responseHeaders = new HttpHeaders();

         //if Item is present and available
        if(item != null && item.getQty()>0)
        {

            if(coins>=2)
            {

                 int coinsReturned = coins - 2;


                responseHeaders.add("X-Coins",
                        String.valueOf(coinsReturned));


            }

            //not enought coins in the machine
            else
            {

                responseHeaders.set("Baeldung-Example-Header",
                        "Value-ResponseEntityBuilderWithHttpHeaders");


            }

        }

        else


        //item out of stock
        {
            responseHeaders.set("Baeldung-Example-Header",
                    "Value-ResponseEntityBuilderWithHttpHeaders");


        }


        return ResponseEntity.ok()
                .headers(responseHeaders).body(null);


    }







}
