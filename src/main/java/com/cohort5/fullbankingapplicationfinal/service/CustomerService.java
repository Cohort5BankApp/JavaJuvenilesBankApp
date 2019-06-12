package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Bill;
import com.cohort5.fullbankingapplicationfinal.model.Customer;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import com.cohort5.fullbankingapplicationfinal.repository.BillRepository;
import com.cohort5.fullbankingapplicationfinal.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BillRepository billRepository;



    public ArrayList<Account> getAccountsByCustomer(Long customer_id) {
        Customer customer = customerRepository.findById(customer_id).get();
        Iterable<Account> accounts = accountRepository.findAll();
        ArrayList<Account> customer_accounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getCustomer_id() == customer_id) {
                customer_accounts.add(account);
            }
        }

        return customer_accounts;
    }

    public ArrayList<Bill> getBillsByCustomer(Long customer_id) {
        Iterable<Bill> bills = billRepository.findAll();
        Iterable<Account> accounts = accountRepository.findAll();
        ArrayList<Bill> customer_bills = new ArrayList<>();
        ArrayList<Account> customer_accounts = new ArrayList<>();
        for (Account account : accounts) {
            if (account.getCustomer_id() == customer_id) {
                customer_accounts.add(account);
            }
            for (Bill bill : bills) {
                for (Account customer_account : customer_accounts) {
                    if (bill.getAccount_id() == customer_account.getAccount_id()) {
                        customer_bills.add(bill);
                    }
                }
            }
        }
        return customer_bills;
    }


    public ArrayList<Customer> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        ArrayList<Customer> these_customers = new ArrayList<>();
        for (Customer customer : customers) {
            these_customers.add(customer);
        }
        return these_customers;
    }

    public Optional<Customer> getCustomerById(Long customer_id){
        return customerRepository.findById(customer_id);
    }

    public Customer createCustomer(Customer customer){
        customerRepository.save(customer);
        return customer;

    }

    public Customer updateCustomer(Customer customer){
        return customerRepository.save(customer);
    }



}
