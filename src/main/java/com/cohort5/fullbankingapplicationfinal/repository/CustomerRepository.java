package com.cohort5.fullbankingapplicationfinal.repository;

import com.cohort5.fullbankingapplicationfinal.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
