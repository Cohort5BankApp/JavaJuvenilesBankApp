package com.cohort5.fullbankingapplicationfinal.service;

import com.cohort5.fullbankingapplicationfinal.model.Withdrawal;
import com.cohort5.fullbankingapplicationfinal.repository.AccountRepository;
import com.cohort5.fullbankingapplicationfinal.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class WithdrawalService {

    @Autowired
    private WithdrawalRepository withdrawalRepository;

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Withdrawal> getWithdrawalById(Long withdrawal_id) {
        return withdrawalRepository.findById(withdrawal_id);
    }

}
