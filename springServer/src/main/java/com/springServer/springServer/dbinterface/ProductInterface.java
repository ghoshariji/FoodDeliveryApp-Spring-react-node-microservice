package com.springServer.springServer.dbinterface;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.springServer.springServer.utils.MultipartSupportConfig;

import jakarta.ws.rs.core.MediaType;

@FeignClient(name = "sproduct", configuration = MultipartSupportConfig.class)
public interface ProductInterface {

    @PostMapping(value = "/api/product/add-product", consumes = MediaType.MULTIPART_FORM_DATA)
    public ResponseEntity<?> addProduct(@RequestParam("name") String name,
            @RequestParam("price") int price,
            @RequestParam("quantity") String quantity,
            @RequestParam("description") String description,
            @RequestParam("productImg") MultipartFile productImg,
            @RequestParam("sellerId") String sellerId);

    @GetMapping("/api/product/get-all-product")
    public ResponseEntity<?> getAllProd();
}
