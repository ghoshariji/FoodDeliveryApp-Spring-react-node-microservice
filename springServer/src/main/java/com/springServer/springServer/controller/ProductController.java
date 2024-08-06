package com.springServer.springServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springServer.springServer.dbinterface.ProductInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/micro/products")
public class ProductController {

    @Autowired
    ProductInterface productInterface;

    @PostMapping("/add")
    public ResponseEntity<?> addProduct(
            @RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("quantity") String quantity,
            @RequestParam("description") String description,
            @RequestParam("productImg") MultipartFile productImg,
            @RequestParam("sellerId") String sellerId) {
        try {
            // Calling Feign client to add the product
            return productInterface.addProduct(name, price, quantity, description, productImg, sellerId);
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-product")
    public ResponseEntity<?> getAllProduct()
    {
        try {
            return productInterface.getAllProd();
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occurred", HttpStatus.BAD_REQUEST);
        }
    }
}


