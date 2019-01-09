package com.gonnect.upload.viewmodels;


import lombok.Getter;
import lombok.Setter;

import java.util.*;

/**
 * Created by xschen on 24/6/2017.
 */
@Getter
@Setter
public class Product {
   private static Random random = new Random();

   private String sku;

   private String name;

   private double price = 10;
   private int status  = 0;
   private int visibility = 0;


   private Date createdAt;

   private Date updatedAt; // format 2017-05-03 03:46:13

   private double weight;

   private String type = "";

   private long position = 0;

   private List<String> links = new ArrayList<>();

   private List<Double> prices = new ArrayList<>();

   private String vendor;
   private Map<String, String> attributes = new HashMap<>();

   private String error;

   private double rating;

   private String tags = "";

   private String token;

   public Product() {

   }

   public Product(String vendor, String productName, String sku, double price, double weight, Map<String, String> properties, List<Double> pricings, String tags) {
      this.name = productName;
      this.vendor = vendor;
      this.sku = sku;
      this.price = price;
      this.weight = weight;
      this.attributes = properties;
      this.prices = pricings;
      this.rating = random.nextInt(3) + 2;
      this.tags = tags;
   }

   public static Random getRandom() {
      return random;
   }

   public static void setRandom(Random random) {
      Product.random = random;
   }

   public String getSku() {
      return sku;
   }

   public void setSku(String sku) {
      this.sku = sku;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public int getStatus() {
      return status;
   }

   public void setStatus(int status) {
      this.status = status;
   }

   public int getVisibility() {
      return visibility;
   }

   public void setVisibility(int visibility) {
      this.visibility = visibility;
   }

   public Date getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(Date createdAt) {
      this.createdAt = createdAt;
   }

   public Date getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(Date updatedAt) {
      this.updatedAt = updatedAt;
   }

   public double getWeight() {
      return weight;
   }

   public void setWeight(double weight) {
      this.weight = weight;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }

   public long getPosition() {
      return position;
   }

   public void setPosition(long position) {
      this.position = position;
   }

   public List<String> getLinks() {
      return links;
   }

   public void setLinks(List<String> links) {
      this.links = links;
   }

   public List<Double> getPrices() {
      return prices;
   }

   public void setPrices(List<Double> prices) {
      this.prices = prices;
   }

   public String getVendor() {
      return vendor;
   }

   public void setVendor(String vendor) {
      this.vendor = vendor;
   }

   public Map<String, String> getAttributes() {
      return attributes;
   }

   public void setAttributes(Map<String, String> attributes) {
      this.attributes = attributes;
   }

   public String getError() {
      return error;
   }

   public void setError(String error) {
      this.error = error;
   }

   public double getRating() {
      return rating;
   }

   public void setRating(double rating) {
      this.rating = rating;
   }

   public String getTags() {
      return tags;
   }

   public void setTags(String tags) {
      this.tags = tags;
   }

   public String getToken() {
      return token;
   }

   public void setToken(String token) {
      this.token = token;
   }

   public static Product createAlert(String errorMessage) {
      Product product = new Product();
      return product.alert(errorMessage);
   }

   public Product alert(String errorMessage) {
      error = errorMessage;
      return this;
   }
}
