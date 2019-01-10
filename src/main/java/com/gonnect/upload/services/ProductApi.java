package com.gonnect.upload.services;


import com.gonnect.upload.viewmodels.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 */
@Service
public class ProductApi  {
   private List<Product> products = new ArrayList<>();

   public Product saveProduct(Product newProduct) {
      products.add(newProduct);
      return newProduct;
   }


   public List<Product> findAll() {
      return products;
   }
}
