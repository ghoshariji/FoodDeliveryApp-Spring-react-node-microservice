package com.product.sproduct.dbinterface;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.sproduct.modal.ProductModal;

public interface ProductInterface extends MongoRepository<ProductModal,String> {
    List<ProductModal> findBysellerId(String id);
}
