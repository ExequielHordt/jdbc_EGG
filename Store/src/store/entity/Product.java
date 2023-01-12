/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.entity;

/**
 *
 * @author Exequiel Hordt
 * @version 15 Nov 2022
 */
public class Product {

    private int code;
    private String name;
    private Double price;
    private int manufacturer_code;

    public Product() {
    }

    public Product(int code, String name, Double price, int manufacturer_code) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.manufacturer_code = manufacturer_code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getManufacturer_code() {
        return manufacturer_code;
    }

    public void setManufacturer_code(int manufacturer_code) {
        this.manufacturer_code = manufacturer_code;
    }

    @Override
    public String toString() {
        return "Product{" + "code=" + code + ", name=" + name + ", price=" + price + ", manufacturer_code=" + manufacturer_code + '}';
    }

}
