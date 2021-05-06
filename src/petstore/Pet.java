/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

import java.io.Serializable;

/**
 *
 * @author macair
 */
public class Pet implements Serializable {
    private String name;
    private String code;
    private Double price;
    
    
    public Pet(String code){
        this.code = code;
    }

    public Pet(String name, String code, Double price) {
        this.name = name;
        this.code = code;
        this.price = price;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PetName: " + this.name + " ,code: " + this.code + " ,price: " + this.price ;
    }
    
     
     
}
