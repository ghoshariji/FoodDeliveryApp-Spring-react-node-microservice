package com.purchase.spurchase.modal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "purchase")
public class PurchaseModal {
    @Id
    private String id;
    private String pname;
    private int pPrice;
    private String pSellerId;
    private String pid;
    private String userId;
    public String getId() {
        return id;
    }
    public String getPname() {
        return pname;
    }
    public int getpPrice() {
        return pPrice;
    }
    public String getpSellerId() {
        return pSellerId;
    }
    public String getPid() {
        return pid;
    }
    public String getUserId() {
        return userId;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }
    public void setpSellerId(String pSellerId) {
        this.pSellerId = pSellerId;
    }
    public void setPid(String pid) {
        this.pid = pid;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "PurchaseModal [id=" + id + ", pname=" + pname + ", pPrice=" + pPrice + ", pSellerId=" + pSellerId
                + ", pid=" + pid + ", userId=" + userId + "]";
    }

    
}
