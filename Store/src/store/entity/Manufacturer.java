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
public class Manufacturer {

    private int code;
    private String name;

    public Manufacturer() {
    }

    public Manufacturer(int code, String name) {
        this.code = code;
        this.name = name;
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

    @Override
    public String toString() {
        return "Manufacturer{" + "code=" + code + ", name=" + name + '}';
    }

}
