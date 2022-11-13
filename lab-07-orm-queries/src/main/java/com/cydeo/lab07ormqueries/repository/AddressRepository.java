package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Address;
import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    //Write a derived query to get all address with a specific customer
    List<Address> findAllByCustomer(Customer customer);//findAll - if more than 1 obj

    //Write a derived query to get address with a specific street (one address)
    Address findByStreet(String street);

    //Write a derived query to get top 3 address with a specific customer email
    List<Address> findTop3ByCustomer_Email(String email);

    //Write a derived query to get all address with a specific customer and name
    List<Address> findAllByCustomerAndName(Customer customer, String name);

    //Write a derived query to list all address where the beginning of the street contains the keyword
    List<Address> findAllByStreetStartingWith(String keyword);

    //Write a JPQL query to get all address with a specific customerId
    @Query("SELECT a FROM Address a WHERE a.customer.id = ?1")//(from address - customer id)
    List<Address> fetchByCustomerId(Long id);
}