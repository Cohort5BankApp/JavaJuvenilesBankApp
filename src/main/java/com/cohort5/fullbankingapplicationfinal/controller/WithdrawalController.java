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
public class WithdrawalController {

    @Autowired
    private WithdrawalService withdrawalService;

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @RequestMapping(path = "withdrawal/{withdrawalId}", method = RequestMethod.GET)
    public Optional<Withdrawal> getWithdrawalById(@PathVariable Long id) {
        Optional optional = withdrawalService.getWithdrawalById(id);
        if(!optional.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND, "Error fetching withdrawal");
        if(optional.isPresent())
            throw new HttpException(HttpStatus.OK, "Success");
        return optional;
    }

    @RequestMapping(path = "/accounts/withdrawal/{withdrawalId}")
    public Optional<Withdrawal> createWithdrawal(@PathVariable Long account_id, Withdrawal withdrawal) {
        withdrawalService.createWithdrawal(account_id,withdrawal);
        Optional<Withdrawal> optional = withdrawalService.getWithdrawalById(withdrawal.getId());
        if(!optional.isPresent())
            throw new HttpException(HttpStatus.NOT_FOUND)
    }

}
