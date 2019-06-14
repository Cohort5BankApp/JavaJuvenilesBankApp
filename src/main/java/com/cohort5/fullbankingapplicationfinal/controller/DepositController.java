package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.model.Deposit;
import com.cohort5.fullbankingapplicationfinal.model.Message;
import com.cohort5.fullbankingapplicationfinal.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepositController {
    @Autowired
    DepositService depositService;

    protected void verifyDeposit(Long depositId){

    }

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public ResponseEntity<?> createDeposit(@PathVariable Long accountId, @RequestBody Deposit deposit){
        depositService.createDeposit(accountId,deposit);
        Optional<Deposit> deposit1 = depositService.getDepositById(deposit.getId());
        Message message = new Message(HttpStatus.CREATED.value(),"Success",deposit1);
        verifyDeposit(deposit.getId());
        return new ResponseEntity<>(message,HttpStatus.CREATED);


    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)

    public ResponseEntity<?> getDepositById(@PathVariable Long depositId){
       Message message = new Message(HttpStatus.OK.value(),"Success",depositService.getDepositById(depositId));
       return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateDeposit(@PathVariable Long depositId, @RequestBody Deposit deposit){
        depositService.updateDeposit(deposit);
        Message message = new Message(HttpStatus.OK.value(),"Success", depositService.getDepositById(depositId));
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
  
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteDeposit(@PathVariable Long depositId){
        /*TODO: editing to extract correct account number from deposit */
        Deposit depositCheck = depositService.getDepositById(depositId).get();
        Long account_id = depositCheck.getAccount_id();
        /* End of edit */
        depositService.deleteDeposit(account_id,depositId);

        Message message = new Message(HttpStatus.OK.value(),"Success");
       return new ResponseEntity<>(message, HttpStatus.OK);


    }
}
