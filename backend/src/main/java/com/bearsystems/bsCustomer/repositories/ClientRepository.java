package com.bearsystems.bsCustomer.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bearsystems.bsCustomer.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
