/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.persistence;

import java.util.ArrayList;
import java.util.Collection;
import store.entity.Manufacturer;

/**
 *
 * @author Exequiel Hordt
 * @version 15 Nov 2022
 */
public class ManufacturerDAO extends DAO {

    //Create Manufacturer
    public void createManufacturer(Manufacturer manufacturer) throws Exception {
        try {
            String query = "INSERT INTO fabricante (codigo,nombre)"
                    + " VALUES('" + manufacturer.getCode() + "', '" + manufacturer.getName() + "');";
            crud(query);
        } catch (Exception e) {
            throw e;
        }
    }

    //Print Manufacturers records
    public Collection<Manufacturer> printRecords() throws Exception {
        try {
            String query = "SELECT * FROM fabricante;";
            query_db(query);
            Collection<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
            while (result.next()) {
                Manufacturer manufacturer = new Manufacturer();
                manufacturer.setCode(result.getInt(1));
                manufacturer.setName(result.getString(2));
                manufacturers.add(manufacturer);
            }
            db_disconnection();
            return manufacturers;
        } catch (Exception e) {
            throw e;
        }
    }

}
