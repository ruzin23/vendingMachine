package com.vending.demo.Services;

import com.vending.demo.Model.Item;
import com.vending.demo.Model.VendingMachine;
import com.vending.demo.Repository.ItemRepository;
import com.vending.demo.Repository.VendingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class InventoryService {


   @Autowired
    ItemRepository itemRepository;

   @Autowired
    VendingMachineRepository vendingMachineRepository;

   @Autowired
   VendingMachineService vendingMachineService;

  public Item getItemById(Long id)
  {
      //Item i = itemRepository.findById(id).orElse(null);

      Optional<Item> itemOptional = itemRepository.findById(id);
      if (itemOptional.isPresent()){
          Item item = itemOptional.get();
          return  item;
      }
      else{
          return null;
      }
  }


  public int getItemQtyById(Long id)
  {

      Item item = getItemById(id);
      return (item!=null)?item.getQty():0;

  }



  public int  getAllInventoryQty()
  {
      int totalItemsRemaining = itemRepository.totalItems();
      return totalItemsRemaining;
  }


  public ArrayList<Integer> getAllInventory()
  {
      ArrayList<Item>  list = new ArrayList<Item>();

      list = (ArrayList)itemRepository.findAll();

      ArrayList<Integer> listOfInventory = new ArrayList<Integer>();

      for( Item i:list )
      {

          listOfInventory.add(i.getQty());

      }
      return listOfInventory;
  }





}
