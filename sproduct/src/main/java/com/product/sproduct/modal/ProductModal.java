package com.product.sproduct.modal;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product")
public class ProductModal {

    @Id
    private String id;
    private String name;
    private int price;
    private String description;
    private String quantity;
    public String getContentType() {
        return contentType;
    }

    private String sellerId;
    private byte[] productImg;
    private String contentType;

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getSellerId() {
        return sellerId;
    }

    public byte[] getProductImg() {
        return productImg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    // storing the value of the data:buffer and content-type:application/json
    public void setProductImg(byte[] productImg) {
        this.productImg = productImg;
    }

    @Override
    public String toString() {
        return "ProductModal [id=" + id + ", name=" + name + ", price=" + price + ", description=" + description
                + ", quantity=" + quantity + ", sellerId=" + sellerId + ", productImg=" + Arrays.toString(productImg)
                + ", contentType=" + contentType + "]";
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

}
