package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.exception.HttpException;
import com.cohort5.fullbankingapplicationfinal.model.Bill;
import com.cohort5.fullbankingapplicationfinal.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.GET)
    public Optional<Bill> getBill (@PathVariable Long bill_id){
       Optional<Bill> optionalBill = billService.getBillById(bill_id);
//
//       if(!optionalBill.isPresent())
//           throw new HttpException(HttpStatus.NOT_FOUND, "error fetching bill");
//       if(optionalBill.isPresent())
//           throw new HttpException(HttpStatus.OK, "Successful");

        return billService.getBillById(bill_id);

    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public void createBill(@RequestBody Bill bill, @PathVariable Long account_Id ){
        billService.createBill(account_Id,bill);
//        Optional<Bill> optionalBill = billService.getBillById(bill.getId());
//         if (!optionalBill.isPresent())
//             throw new HttpException(HttpStatus.NOT_FOUND, "error fetching bill");
//         if (optionalBill.isPresent())
//             throw new HttpException(HttpStatus.OK, "Successful");

    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.PUT)
    public void updateBill(@RequestBody Bill bill, @PathVariable Long bill_id) {
        /*TODO: adding code to get account id*/
        Long account_Id = bill.getAccount_id();
        /* TODO: End of edit */
        billService.updateBill(bill, account_Id);
        Bill optionalBill = billService.getBillById(bill_id).get();
//        if (optionalBill.toString() != bill.toString())
//            throw new HttpException(HttpStatus.NOT_FOUND, "error updating bill");
//        if (optionalBill.toString() == bill.toString())
//            throw new HttpException(HttpStatus.OK, "Successful");
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public void deleteBill(@PathVariable Long bill_Id){
        /*TODO: adding code to get account id*/
        Bill bill = billService.getBillById(bill_Id).get();
        Long account_Id = bill.getAccount_id();
        /* TODO: End of edit */
//        billService.deleteBill(bill_Id, account_Id);
//       Optional<Bill> optionalBill = billService.getBillById(bill_Id);
//       if(optionalBill.isPresent())
//           throw new HttpException(HttpStatus.NOT_FOUND, "error deleting bill");
//       if(!optionalBill.isPresent())
//           throw new HttpException(HttpStatus.OK, "Successful");
        billService.deleteBill(bill_Id,account_Id);
    }




}
