package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Bill;
import com.cohort5.fullbankingapplicationfinal.model.Customer;
import com.cohort5.fullbankingapplicationfinal.service.BillService;
import com.cohort5.fullbankingapplicationfinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillService billService;

    @PostMapping(value = "/customers")
    public Optional<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        Long customer_id = createdCustomer.getCustomer_id();
        Optional<Customer> customerCheck = customerService.getCustomerById(customer_id);
        return customerCheck;
    }

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomers() {
        ArrayList<Customer> customers = customerService.getAllCustomers();

        return ResponseEntity.status(HttpStatus.OK)
                .body(customers);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomerById(@PathVariable("id") Long customer_id){
        Customer customer = customerService.getCustomerById(customer_id).get();
        return ResponseEntity.status(HttpStatus.OK)
                .body(customer);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable("id") Long customer_id, @RequestBody Customer customer){
        customerService.updateCustomer(customer);
        Customer customerCheck = customerService.getCustomerById(customer.getCustomer_id()).get();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(customerCheck);

    }

    @GetMapping(value = "/customers/{id}/bills")
    public ResponseEntity getBillsByCustomer(@PathVariable("id") Long customer_id){
        ArrayList<Bill> customer_bills = customerService.getBillsByCustomer(customer_id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customer_bills);

    }

    @GetMapping(value = "customers/{id}/accounts")
    public ResponseEntity getAccountsByCustomer(@PathVariable("id") Long customer_id){
        ArrayList<Account> customer_accounts = customerService.getAccountsByCustomer(customer_id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(customer_accounts);

    }


}
