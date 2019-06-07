package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.Account;
import com.cohort5.fullbankingapplicationfinal.model.Bill;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import com.cohort5.fullbankingapplicationfinal.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;
@CrossOrigin(source = "*", allowedHeaders = "*")
@Service
public class BillService {

    @Autowired
    BillRepository billRepository;
    @Autowired
    AccountRepository accountRepository;

    public void createBill(Long account_Id,Bill bill) {
        billRepository.save(bill);
      Account account = accountRepository.findById(account_Id).get();
     double newBill =  account.getBalance() - bill.getPayment_amount();
     bill.setBalance(newBill);
    }

    public Optional<Bill> getBillById(Long bill_id){
        return  billRepository.findById(bill_id);
    }

     public Iterable<Bill> getAllBills(){
        return billRepository.findAll();
     }

     public void updateBill(Bill bill, Long account_Id){
        billRepository.findById(bill_id);
        Account account = accountRepository.findById(account_Id).get();
        Double newBill = account.getBalance() - bill.getPayment_amount();
        bill.seBalance(newBill);
     }

     public void deleteBill(Long bill_id, Long account_Id){
        billRepository.deleteById(bill_id);
        Account account = accountRepository.findById(account_Id).get();
        Bill bill = billRepository.findById(bill_id).get();
        double returnMoney = account.getBalance + bill.getPayment_amount;
        account.setBalance(returnMoney);
     }
}
