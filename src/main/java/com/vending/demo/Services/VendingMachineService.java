package com.vending.demo.Services;


import com.vending.demo.Model.Item;
import com.vending.demo.Model.VendingMachine;
import com.vending.demo.Repository.ItemRepository;
import com.vending.demo.Repository.VendingMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class VendingMachineService {

   @Autowired
    VendingMachineRepository vendingMachineRepository;



    public int addCoin() {
        Long id = new Long(1234);

        Optional<VendingMachine> machineOptional = vendingMachineRepository.findById(id);
        if (machineOptional.isPresent()) {
            VendingMachine machine = machineOptional.get();
            machine.setCoins(machine.getCoins() + 1);
            vendingMachineRepository.save(machine);
            return machine.getCoins();
        } else {
            VendingMachine machine = new VendingMachine(new Long(1234),1);
            vendingMachineRepository.save(machine);
            return machine.getCoins();
        }


    }






   public int removeCoins()
   {
      Long id = new Long(1234);
      VendingMachine machine = vendingMachineRepository.getOne(id);

      int coins = machine.getCoins();
      return machine.getCoins()>2?(coins-2):0;

   }





   public int getCoinsInTheMachine()
   {
       Long id = new Long(1234);
       Optional<VendingMachine> machineOptional = vendingMachineRepository.findById(id);
       if (machineOptional.isPresent()) {
           VendingMachine machine = machineOptional.get();
           return machine.getCoins();
       } else {
           VendingMachine machine = new VendingMachine(new Long(1234),0);
           vendingMachineRepository.save(machine);
           return machine.getCoins();
       }

   }



}
