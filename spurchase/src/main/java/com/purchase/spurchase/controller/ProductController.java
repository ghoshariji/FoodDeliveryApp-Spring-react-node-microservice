package com.purchase.spurchase.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purchase.spurchase.dbinheritance.ProductInterface;
import com.purchase.spurchase.modal.PurchaseModal;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductInterface productInterface;

    @PostMapping("/save-bill")
    public ResponseEntity<?> saveBill(@RequestBody PurchaseModal data) {
        try {
            PurchaseModal newData = new PurchaseModal();
            newData.setPid(data.getPid());
            newData.setPname(data.getPname());
            newData.setUserId(data.getUserId());
            newData.setpPrice(data.getpPrice());
            newData.setpSellerId(data.getpSellerId());
            productInterface.save(newData);
            return new ResponseEntity<>("Bill Updated", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error Occured", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-bill-user")
    public ResponseEntity<?> gateBill(@RequestBody String data) {
        try {
            Optional<PurchaseModal> newData = productInterface.findById(data);
            if (newData.isPresent()) {
                PurchaseModal getData = newData.get();
                return new ResponseEntity<>(getData, HttpStatus.OK);

            } else {
                return new ResponseEntity<>("Bill Updated", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("An error Occured", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-bill-seller")
    public ResponseEntity<?> getBillSeller(@RequestBody String id) {
        try {
            List<PurchaseModal> getData = productInterface.existsBypSellerId(id);
            return new ResponseEntity<>(getData, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error Occured", HttpStatus.BAD_REQUEST);
        }
    }
}
