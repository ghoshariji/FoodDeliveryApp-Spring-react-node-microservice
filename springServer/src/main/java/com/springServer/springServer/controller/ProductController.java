package com.springServer.springServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springServer.springServer.dbinterface.ProductInterface;
import com.springServer.springServer.modal.ProductModal;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/micro/products")
public class ProductController {

    @Autowired
    private ProductInterface productInterface;

    @PostMapping("/add-products")
    public ResponseEntity<?> addProducts(@RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("quantity") String quantity,
            @RequestParam("description") String description,
            @RequestParam("productImg") MultipartFile productImg,
            @RequestParam("sellerId") String sellerId) {
        try {
            return productInterface.addProduct(name, price, quantity, description, productImg, sellerId);
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-product")
    public ResponseEntity<?> getAllProduct() {
        try {
            ResponseEntity<?> response = productInterface.getAllProd();
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occurred", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit-products")
    public ResponseEntity<?> editProducts(@RequestBody ProductModal data) {
        try {
            return new ResponseEntity<>(productInterface.editProduct(data),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occurred", HttpStatus.BAD_REQUEST);
        }
    }
}
