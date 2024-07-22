package com.purchase.spurchase.dbinheritance;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.purchase.spurchase.modal.PurchaseModal;

public interface ProductInterface extends MongoRepository<PurchaseModal,String> {
    List<PurchaseModal> existsBypSellerId(String pSellerId);
}
