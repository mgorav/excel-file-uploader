package com.gonnect.upload.controllers;


import com.gonnect.upload.services.ProductApi;
import com.gonnect.upload.viewmodels.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Controller
public class ProductRestController {

   @Autowired
   private ProductApi productApi;

   @RequestMapping(value="/erp/get-products", method = RequestMethod.GET)
   public @ResponseBody List<Product> getProducts() {
      return productApi.findAll();
   }

   @RequestMapping(value="/erp/count-products", method = RequestMethod.GET)
   public @ResponseBody Map<String, Integer> countProducts() {
      Map<String, Integer> result = new HashMap<>();
      result.put("count", productApi.findAll().size());
      return result;
   }
}
