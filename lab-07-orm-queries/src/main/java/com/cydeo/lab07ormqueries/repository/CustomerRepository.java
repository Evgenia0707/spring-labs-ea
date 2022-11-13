package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //Write a derived query to get all customer by id -- null pointer exception (use Optional)
    Optional<Customer> findAllById(long id);

    //Write a JPQL query to get customer by email
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Customer retrieveByCustomerEmail(@Param("email") String email);
}
