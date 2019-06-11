package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.Message;
import com.cohort5.fullbankingapplicationfinal.model.Withdrawal;
import com.cohort5.fullbankingapplicationfinal.repository.WithdrawalRepository;
import com.cohort5.fullbankingapplicationfinal.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WithdrawalController {

    @Autowired
    WithdrawalService withdrawalService;


    @RequestMapping(path = "/withdrawals/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getWithdrawalById(@PathVariable Long id) {
        //withdrawalService.getWithdrawalById(id);
        Message message = new Message(HttpStatus.OK.value(), "Success", withdrawalService.getWithdrawalById(id));
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(path = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public ResponseEntity<?> createWithdrawal(@PathVariable Long accountId, @RequestBody Withdrawal withdrawal) {
        withdrawal.setAccount_id(accountId);
        withdrawalService.createWithdrawal(accountId, withdrawal);
        Message message = new Message(HttpStatus.CREATED.value(), "Success", withdrawalService.getWithdrawalById(withdrawal.getId()));
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/withdrawals/{withdrawal_id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateWithdrawal(@RequestBody Withdrawal withdrawal, @PathVariable Long withdrawal_id) {
        withdrawalService.updateWithdrawal(withdrawal);
        Message message = new Message(HttpStatus.OK.value(), "Success", withdrawalService.getWithdrawalById(withdrawal_id));
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @RequestMapping(path = "/withdrawals/{withdrawal_id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteWithdrawal(@PathVariable Long withdrawal_id) {
        Long account_id = withdrawalService.getWithdrawalById(withdrawal_id).get().getAccount_id();
        withdrawalService.deleteWithdrawal(withdrawal_id, account_id);
        Message message = new Message(HttpStatus.OK.value(), "Success");
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
