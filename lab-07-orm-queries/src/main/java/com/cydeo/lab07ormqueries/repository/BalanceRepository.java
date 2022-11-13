package com.cydeo.lab07ormqueries.repository;


import com.cydeo.lab07ormqueries.entity.Balance;
import com.cydeo.lab07ormqueries.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {

    //Write a derived query to check balance exists for specific customer
    Boolean existsBalancesByCustomer(Customer customer);
    Boolean existsBalanceByCustomerId(Long id);

    //Write a derived query to get balance for specific customer (one balance)
    Balance findByCustomer(Customer customer);
    Balance findByCustomerId(Long id);

    //Write a native query to get top 5 max balance (access table - balance)
    @Query(value = "SELECT * FROM balance ORDER BY amount DESC limit 5 ", nativeQuery = true)
    List<Balance> fetchTop5Balance(BigDecimal amount);

  //  "select distinct * from balance where amount is not null order by amount desc limit 5"

    //Write a derived query to get all balances greater than or equal specific balance amount
    List<Balance> findAllByAmountIsGreaterThanEqual(BigDecimal amount);

    //Write a native query to get all balances less than specific balance amount (table - balance)
    @Query(value = "SELECT  * FROM balance WHERE amount < ?1 ", nativeQuery = true)
    List<Balance> retrieveAllBalancesLessThanSpecificAmount(@Param("amount") BigDecimal amount);
}
