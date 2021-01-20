package com.sapo.ex7_RestfullAPI_Spring.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="inventory")
@Data
public class InventoryEntity extends BaseEntity{
	
   @Column(name="inventory_code")
   private String inventoryCode;
   
   @Column(name="inventory_name")
   private String inventoryName;
   
   @Column(name="address")
   private String address;

public String getInventoryCode() {
	return inventoryCode;
}

public void setInventoryCode(String inventoryCode) {
	this.inventoryCode = inventoryCode;
}

public String getInventoryName() {
	return inventoryName;
}

public void setInventoryName(String inventoryName) {
	this.inventoryName = inventoryName;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}
  
//   @OneToMany(mappedBy="inventory")
//   private List<ProductEntity> products = new ArrayList<>();
//   
   
   
   
   
}
