/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.service;

import java.util.Collection;
import store.entity.Manufacturer;
import store.persistence.ManufacturerDAO;

/**
 *
 * @author Exequiel Hordt
 * @version 15 Nov 2022
 */
public class ManufacturerService {

    private ManufacturerDAO manufacturerDAO;

    public ManufacturerService() {
        this.manufacturerDAO = new ManufacturerDAO();
    }

    public void createManufacturer(String name) throws Exception {
        try {
            if (name.trim().isEmpty() || name == null) {
                throw new Exception("Debe indicar el nombre del fabricante");
            }
            //Insert Manufacturers values
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setName(name);
            manufacturerDAO.createManufacturer(manufacturer);
        } catch (Exception e) {
            throw e;
        }
    }

    public void printRecords() throws Exception {
        try {
            Collection<Manufacturer> manufacturers = manufacturerDAO.printRecords();
            if (manufacturers.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Manufacturer manufacturer : manufacturers) {
                    System.out.println(manufacturer);
                    System.out.println("");
                }
            }
        } catch (Exception e) {
        }
    }
}
