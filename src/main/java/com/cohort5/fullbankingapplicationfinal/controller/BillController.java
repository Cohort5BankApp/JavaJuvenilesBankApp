package com.cohort5.fullbankingapplicationfinal.controller;

import com.cohort5.fullbankingapplicationfinal.model.Bill;
import com.cohort5.fullbankingapplicationfinal.model.Message;
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
    public ResponseEntity<?> getBill (@PathVariable("billId") Long bill_id){
       Message message = new Message(HttpStatus.OK.value(), "Success", billService.getBillById(bill_id));
       return new ResponseEntity<>(message,HttpStatus.OK);
//
//       if(!optionalBill.isPresent())
//           throw new HttpException(HttpStatus.NOT_FOUND, "error fetching bill");
//       if(optionalBill.isPresent())
//           throw new HttpException(HttpStatus.OK, "Successful");



    }

    @RequestMapping(value = "/accounts/{accountId}/bills", method = RequestMethod.POST)
    public ResponseEntity<?> createBill(@RequestBody Bill bill, @PathVariable("accountId") Long account_id ){
        bill.setAccount_id(account_id);
        billService.createBill(account_id,bill);
        Optional<Bill> bill1 = billService.getBillById(bill.getId());
        Message message = new Message(HttpStatus.CREATED.value(), "Success",bill1 );

        return new ResponseEntity<>(message,HttpStatus.CREATED);
//        Optional<Bill> optionalBill = billService.getBillById(bill.getId());
//         if (!optionalBill.isPresent())
//             throw new HttpException(HttpStatus.NOT_FOUND, "error fetching bill");
//         if (optionalBill.isPresent())
//             throw new HttpException(HttpStatus.OK, "Successful");

    }

    @RequestMapping(value = "/accounts/{accountId}/bills/{billId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBill(@RequestBody Bill bill, @PathVariable("billId") Long bill_id,@PathVariable("accountId") Long account_Id) {
        bill.setAccount_id(account_Id);
        billService.updateBill(bill, account_Id);
        Message message = new Message(HttpStatus.OK.value(),"Success", billService.getBillById(bill_id));
        return new ResponseEntity<>(message,HttpStatus.OK);
//        Bill optionalBill = billService.getBillById(bill_id).get();
//        if (optionalBill.toString() != bill.toString())
//            throw new HttpException(HttpStatus.NOT_FOUND, "error updating bill");
//        if (optionalBill.toString() == bill.toString())
//            throw new HttpException(HttpStatus.OK, "Successful");
    }

    @RequestMapping(value = "/bills/{billId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBill(@PathVariable("billId") Long bill_Id){
        /*TODO: adding code to get account id*/
        Bill bill = billService.getBillById(bill_Id).get();
        Long account_Id = bill.getAccount_id();
        /* TODO: End of edit */
//
        billService.deleteBill(bill_Id,account_Id);

        Message message = new Message(HttpStatus.OK.value() , "Success");
        return new ResponseEntity<>(message,HttpStatus.OK);
    }




}
