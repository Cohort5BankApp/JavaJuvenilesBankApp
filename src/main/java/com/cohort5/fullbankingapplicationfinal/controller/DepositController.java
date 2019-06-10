package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.Deposit;
import com.cohort5.fullbankingapplicationfinal.repository.DepositRepository;
import com.cohort5.fullbankingapplicationfinal.service.DepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepositController {
    @Autowired
    DepositService depositService;

    @RequestMapping(value = "/accounts/{accountId}/deposits", method = RequestMethod.POST)
    public Deposit createDeposit(@PathVariable Long account_Id, @RequestBody Deposit deposit){
        depositService.createDeposit(account_Id,deposit);
        Optional<Deposit> depost1 = depositService.getDepositById(deposit.getId());
//        if(!depost1.isPresent())
//            throw new HttpException(HttpStatus.NOT_FOUND, "Error creating Deposit");
//        if(depost1.isPresent())
//            throw new HttpException(HttpStatus.CREATED,"Success");
        return depost1.get();

    }

    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.GET)
    public Optional<Deposit> getDepositById(@PathVariable Long deposit_Id){
        Optional<Deposit> deposit1 =depositService.getDepositById(deposit_Id);
        if(!deposit1.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "Error getting id");
        if(deposit1.isPresent())
            throw new HttpException(HttpStatus.OK, "Success");
        return deposit1;
    }
    @RequestMapping(value = "/deposits/{depositId}", method = RequestMethod.PUT)
    public Deposit updateDeposit(@PathVariable Long deposit_Id, @RequestBody Deposit deposit){
        depositService.updateDeposit(deposit_Id,deposit);
        Deposit deposit1 = depositService.getDepositById(deposit_Id).get();
        if (deposit.toString() != deposit1.toString())
            throw new HttpException(HttpStatus.NOT_FOUND, "Error getting id");
        if (deposit.toString() == deposit1.toString())
            throw new HttpException(HttpStatus.OK, "Updated id: "+ deposit_Id);
        return deposit1;
    }
    @RequestMapping(value = "/deposits/{depositsId}", method = RequestMethod.DELETE)
    public void deleteDeposit(@PathVariable Long deposit_Id){
        /*TODO: editing to extract correct account number from deposit */
        Deposit depositCheck = depositService.getDepositById(deposit_Id).get();
        Long account_id = depositCheck.getAccount_id();
        /* End of edit */
        depositService.deleteDeposit(deposit_Id,account_id);
        Optional<Deposit> deposit = depositService.getDepositById(deposit_Id);
        if (!deposit.isPresent())
            throw new HttpException(HttpStatus.OK, "Deleted id: " + deposit_Id);
        if(deposit.isPresent())
            throw new HttpException(HttpStatus.BAD_REQUEST, "Error deleting id: " +deposit_Id);
    }
}
