package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.model.Deposit;
import com.cohort5.fullbankingapplicationfinal.repository.DepositRepository;
import com.cohort5.fullbankingapplicationfinal.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class DepositController {
    @Autowired
    public DepositService depositService;

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public Deposit createDeposit(@PathVariable Long account_Id, Deposit deposit){
        depositService.createDeposit(account_Id,deposit);
        return depositService.getDepositById(deposit.getId()).get();
    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public Optional<Deposit> getDepositById(@PathVariable Long deposit_Id){
        return depositService.getDepositById(deposit_Id);
    }
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public Deposit updateDeposit(@PathVariable Long deposit_Id, @RequestBody Deposit deposit){
        depositService.updateDeposit(deposit_Id,deposit);
        return depositService.getDepositById(deposit_Id).get();
    }
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.DELETE)
    public void deleteDeposit(@PathVariable Long deposit_Id, Long account_Id){
        depositService.deleteDeposit(deposit_Id,account_Id);
    }
}
