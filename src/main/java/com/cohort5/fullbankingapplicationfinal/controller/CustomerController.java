package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Bill;
import com.cohort5.fullbankingapplicationfinal.model.Customer;
import com.cohort5.fullbankingapplicationfinal.service.BillService;
import com.cohort5.fullbankingapplicationfinal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private BillService billService;

    @PostMapping(value = "/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer){
        Customer createdCustomer = customerService.createCustomer(customer);
        Long customer_id = createdCustomer.getId();
        Optional<Customer> customerCheck = customerService.getCustomerById(customer_id);
        if(!customerCheck.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "error creating customer");
        if(customerCheck.isPresent())
            throw new HttpException(HttpStatus.CREATED, "success");
        return createdCustomer;
    }

    @GetMapping(value = "/all")
    public Iterable<Customer> getAllCustomers(){
        ArrayList<Customer> customers = customerService.getAllCustomers();
        if(customers.size() < 1)
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching customers");
        if(customers.size() > 0)
            throw new HttpException(HttpStatus.OK, "success");
        return customerService.getAllCustomers();
    }

    @GetMapping(value = "/{id}")
    public Optional<Customer> getCustomerById(@PathVariable("id") Long customer_id){
        Optional<Customer> customer = customerService.getCustomerById(customer_id);
        if(!customer.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching customer");
        if(customer.isPresent())
            throw new HttpException(HttpStatus.OK, "success");
        return customer;
    }

    @PutMapping(value = "/{id}")
    public Customer updateCustomer(@PathVariable("id") Long customer_id, @RequestBody Customer customer){
        customerService.updateCustomer(customer);
        Optional<Customer> customerCheck = customerService.getCustomerById(customer.getId());
        if(!customerCheck.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "error updating customer");
        if(customerCheck.isPresent())
            throw new HttpException(HttpStatus.OK, "success");

        return customer;
    }

    @GetMapping(value = "/{id}/bills")
    public Iterable<Bill> getBillsByCustomer(@PathVariable("id") Long customer_id){
        ArrayList<Bill> customer_bills = customerService.getBillsByCustomer(customer_id);
        if(customer_bills.size() < 1)
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching bills");
        if(customer_bills.size() > 0)
            throw new HttpException(HttpStatus.OK, "success");
        return customer_bills;
    }

    @GetMapping(value = "/{id}/accounts")
    public Iterable<Account> getAccountsByCustomer(@PathVariable("id") Long customer_id){
        ArrayList<Account> customer_accounts = customerService.getAccountsByCustomer(customer_id);
        if(customer_accounts.size() < 1)
            throw new HttpException(HttpStatus.NOT_FOUND, "error fetching accounts");
        if(customer_accounts.size()> 0)
            throw new HttpException(HttpStatus.OK, "success");

        return customer_accounts;
    }


}
