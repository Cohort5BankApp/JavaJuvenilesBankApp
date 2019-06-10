package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.Withdrawal;
import com.cohort5.fullbankingapplicationfinal.repository.WithdrawalRepository;
import com.cohort5.fullbankingapplicationfinal.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;


    @RequestMapping(path = "/withdrawals/{withdrawalId}", method = RequestMethod.GET)
    public Optional<Withdrawal> getWithdrawalById(@PathVariable Long id) {
        Optional optional = withdrawalService.getWithdrawalById(id);
//        if(!optional.isPresent())
//            throw new HttpException(HttpStatus.NOT_FOUND, "Error fetching withdrawal");
//        if(optional.isPresent())
//            throw new HttpException(HttpStatus.OK, "Success");
        return optional;
    }

    /* TODO: adding RequestMethod.POST to RequestMethod */
    @RequestMapping(path = "/accounts/{accountId}/withdrawals", method = RequestMethod.POST)
    public Optional<Withdrawal> createWithdrawal(@RequestBody Long account_id, @RequestBody Withdrawal withdrawal) {
        withdrawalService.createWithdrawal(account_id,withdrawal);
        Optional<Withdrawal> optional = withdrawalService.getWithdrawalById(withdrawal.getId());
//        if(!optional.isPresent())
//            throw new HttpException(HttpStatus.NOT_FOUND, "Error creating withdrawal");
//        if(optional.isPresent())
//            throw new HttpException(HttpStatus.CREATED, "Success");
        return optional;
    }

    @RequestMapping(path = "/withdrawals/{withdrawalId}", method = RequestMethod.PUT)
    public Withdrawal updateWithdrawal(@RequestBody Withdrawal withdrawal) {
        /* TODO: adding line 47 to pull the account id from the withdrawal */
        Long account_id = withdrawal.getAccount_id();
        /* End of edit */
        withdrawalService.updateWithdrawal(account_id, withdrawal);
        Withdrawal optional = withdrawalService.getWithdrawalById(withdrawal.getId()).get();
//        if(optional.toString() != withdrawal.toString())
//            throw new HttpException(HttpStatus.NOT_FOUND, "unable to update withdrawal");
//        if(optional.toString() == withdrawal.toString())
//            throw new HttpException(HttpStatus.OK, "Success");
        return optional;
    }

    /*TODO: change RequestMethod from .get to .delete */
    @RequestMapping(path = "/withdrawals/{withdrawalId}", method = RequestMethod.DELETE)
    public void deleteWithdrawal(@PathVariable Long withdrawal_id) {
        /*TODO: editing method to pull correct account_id */
        Withdrawal withdrawalCheck = withdrawalService.getWithdrawalById(withdrawal_id).get();
        Optional<Withdrawal> optional = withdrawalService.getWithdrawalById(withdrawalCheck.getId());
        Long account_id = withdrawalCheck.getAccount_id();
        /*End of edit */
        withdrawalService.deleteWithdrawal(account_id, withdrawal_id);
//        if(!optional.isPresent())
//            throw new HttpException(HttpStatus.OK, "Success");
//        if(optional.isPresent())
//            throw new HttpException(HttpStatus.BAD_REQUEST, "error deleting withdrawal");
    }

}
