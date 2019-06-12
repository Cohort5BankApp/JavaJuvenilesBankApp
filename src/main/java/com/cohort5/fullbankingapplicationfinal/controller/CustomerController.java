package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.ExceptionThrower;
//import com.cohort5.fullbankingapplicationfinal.exception.GeneralErrorException;
//import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
//import com.cohort5.fullbankingapplicationfinal.exception.RecordNotFoundException;
import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Bill;
import com.cohort5.fullbankingapplicationfinal.model.Customer;
import com.cohort5.fullbankingapplicationfinal.model.Message;
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

//    public void verifyCustomer(Long customer_id) throws HttpException{
//        Optional<Customer> customer = customerService.getCustomerById(customer_id);
//        if (!customer.isPresent())
//            throw new HttpException();
//    }

    @PostMapping(value = "/customers")
    public ResponseEntity createCustomer(@RequestBody Customer customer) throws Exception{
        Customer createdCustomer = customerService.createCustomer(customer);
//        Long customer_id = createdCustomer.getCustomer_id();
//        verifyCustomer(customer_id);
//        Message message = new Message(HttpStatus.CREATED.value(), "Success", createdCustomer);
//        return new ResponseEntity<>(message, HttpStatus.CREATED);

        ExceptionThrower exceptionThrower = new ExceptionThrower();
        exceptionThrower.throwGeneralException();

        return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
    }

    @GetMapping(value = "/customers")
    public ResponseEntity getAllCustomers() {
        ArrayList<Customer> customers = customerService.getAllCustomers();
        Message message = new Message(HttpStatus.OK.value(), "Success", customers);
        if(customers == null) {
            message.setCode(HttpStatus.NOT_FOUND.value());
            message.setMessage("error fetching customers");
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getCustomerById(@PathVariable("id") Long customer_id){
        Optional<Customer> customer = customerService.getCustomerById(customer_id);
            Message message = new Message(HttpStatus.OK.value(), "Success", customer);
            return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping(value = "/customers/{id}")
    public ResponseEntity updateCustomer(@PathVariable("id") Long customer_id, @RequestBody Customer customer){
        Optional<Customer> originalCustomer = customerService.getCustomerById(customer_id);
        customerService.updateCustomer(customer);
        Customer customerCheck = customerService.getCustomerById(customer.getCustomer_id()).get();
        Message message = new Message(HttpStatus.OK.value(), "Success", customerCheck);
        if(originalCustomer.toString() == customerCheck.toString()) {
            message.setCode(HttpStatus.NOT_FOUND.value());
            message.setMessage("error updating customer");
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}/bills")
    public ResponseEntity getBillsByCustomer(@PathVariable("id") Long customer_id){
        ArrayList<Bill> customer_bills = customerService.getBillsByCustomer(customer_id);
        Message message = new Message(HttpStatus.OK.value(), "Success", customer_bills);
        if(customer_bills == null){
            message.setCode(HttpStatus.NOT_FOUND.value());
            message.setMessage("Error fetching bills");
        }
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "customers/{id}/accounts")
    public ResponseEntity getAccountsByCustomer(@PathVariable("id") Long customer_id){
        ArrayList<Account> customer_accounts = customerService.getAccountsByCustomer(customer_id);
        Message message = new Message(HttpStatus.OK.value(), "Success", customer_accounts);
        if(customer_accounts == null) {
            message.setCode(HttpStatus.NOT_FOUND.value());
            message.setMessage("error fetching accounts");
        }
        return new ResponseEntity<>(message, HttpStatus.OK);

    }


}
