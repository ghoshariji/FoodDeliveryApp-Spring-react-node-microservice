package com.springServer.springServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springServer.springServer.dbinterface.ProductInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/micro/products")
public class ProductController {

    @Autowired
    private ProductInterface productInterface;

    @GetMapping("/get-product")
    public ResponseEntity<?> getAllProduct() {
        try {
            ResponseEntity<?> response = productInterface.getAllProd();
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occurred", HttpStatus.BAD_REQUEST);
        }
    }
}
