package com.gonnect.upload.services;


import com.gonnect.upload.viewmodels.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xschen on 9/11/2017.
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
