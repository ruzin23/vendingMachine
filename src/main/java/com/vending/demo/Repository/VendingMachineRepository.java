package com.vending.demo.Repository;


import com.vending.demo.Model.VendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;





public interface VendingMachineRepository extends JpaRepository<VendingMachine,Long>
{





}