package com.product.sproduct.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.product.sproduct.dbinterface.ProductInterface;
import com.product.sproduct.modal.ProductModal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "*")
public class ProductController {

    // final keyword uses for the immutabilty for the One time Assignment, Cannot be
    // reassigned twice
    @Autowired
    private ProductInterface productInterface;

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestBody ProductModal data) {
        try {
            ProductModal newData = new ProductModal();
            newData.setName(data.getName());
            newData.setPrice(data.getPrice());
            newData.setDescription(data.getDescription());
            newData.setProductImg(data.getProductImg());
            newData.setQuantity(data.getQuantity());
            newData.setSellerId(data.getSellerId());
            productInterface.save(newData);
            return new ResponseEntity<>("Product Added Successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occured", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/edit-product")
    public ResponseEntity<?> eidtProcut(@RequestBody ProductModal data) {
        try {
            Optional<ProductModal> newData = productInterface.findById(data.getId());
            if (newData.isPresent()) {
                ProductModal updateData = newData.get();
                updateData.setName(data.getName());
                updateData.setPrice(data.getPrice());
                updateData.setDescription(data.getDescription());
                updateData.setProductImg(data.getProductImg());
                updateData.setQuantity(data.getQuantity());
                productInterface.save(updateData);
                return new ResponseEntity<>("Product Added Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Internal Server Error", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occured", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete-product")
    public ResponseEntity<?> deleteProduct(@RequestParam String id) {
        try {
            Optional<ProductModal> getData = productInterface.findById(id);
            if (getData.isPresent()) {
                productInterface.deleteById(id);
                return new ResponseEntity<>("Product Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Internal Server Error", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occured", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-all-product")
    public ResponseEntity<?> getAllData() {
        try {
            List<ProductModal> data = productInterface.findAll();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occured", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-seller-product")
    public ResponseEntity<?> getSellerProduct(@RequestParam String id) {
        try {
            List<ProductModal> sellerProduct = productInterface.findBysellerId(id);
            return new ResponseEntity<>(sellerProduct, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("An Error Occured", HttpStatus.BAD_REQUEST);
        }

    }

}
