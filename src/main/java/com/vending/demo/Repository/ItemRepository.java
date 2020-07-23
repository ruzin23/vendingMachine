package com.vending.demo.Repository;



import com.vending.demo.Model.Item;
import com.vending.demo.Model.VendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<Item,Long> {

    @Query("SELECT SUM(qty) FROM Item")
    int totalItems();

}
