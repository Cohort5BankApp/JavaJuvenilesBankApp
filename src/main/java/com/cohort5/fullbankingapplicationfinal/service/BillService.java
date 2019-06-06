package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Bill;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import com.cohort5.fullbankingapplicationfinal.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BillService {

    @Autowired
    BillRepository billRepository;
    AccountRepository accountRepository;

    public void createBill(Long account_Id,Bill bill) {
        billRepository.save(bill);
      Account account = accountRepository.findById(account_Id).get();
      bill.setAccount_Id(account_Id);
     double newBill =  account.getBalance - bill.getPayment_amount;

     bill.setBalance(newBill);
    }

    public Optional<Bill> getBillById(Long bill_id){
        return  billRepository.findById(bill_id);
    }

     public Iterable<Bill> getAllBills(){
        return billRepository.findAll();
     }

     public void updateBill(Bill bill, Long bill_id, Long account_Id){
        billRepository.findById(bill_id);
        Account account = accountRepository.findById(account_Id).get();
        bill.setAccount_Id(account_Id);
     }

     public void deleteBill(Long bill_id, Long account_Id){
        billRepository.deleteById(bill_id);
        Account account = accountRepository.findById(account_Id).get();
        Bill bill = billRepository.findById(bill_id).get();
        double returnMoney = account.getBalance + bill.getPayment_amount;
        account.setBalance(returnMoney);
     }
}
