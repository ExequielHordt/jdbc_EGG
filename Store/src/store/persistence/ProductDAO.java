/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.persistence;

import java.util.ArrayList;
import java.util.Collection;
import store.entity.Product;

/**
 *
 * @author Exequiel Hordt
 * @version 15 Nov 2022
 */
public final class ProductDAO extends DAO {

    //Insert Product
    public void insertProduct(Product product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("Debe indicar un producto");
            }
            String query = "INSERT INTO producto (codigo,nombre,precio,codigo_fabricante)"
                    + "VALUES('" + product.getCode() + "', '" + product.getName() + "', '" + product.getPrice() + "', '" + product.getManufacturer_code() + "');";
            crud(query);
        } catch (Exception e) {
            throw e;
        }

    }

    //Update Product
    public void updateProduct(Product product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("Debe indicar un producto que desea modificar");
            }
            String query = "UPDATE producto "
                    + "SET nombre = '" + product.getName() + "', " + "precio = '" + product.getPrice() + "', " + "codigo_fabricante = '" + product.getManufacturer_code()
                    + "' WHERE codigo = '" + product.getCode() + "';";
            crud(query);
        } catch (Exception e) {
            throw e;
        }
    }

    //Delete Product
    public void DeleteProduct(Product product) throws Exception {
        try {
            if (product == null) {
                throw new Exception("Debe indicar el producto a eliminar");
            }
            String query = "DELETE FROM producto WHERE codigo = '" + product.getCode() + "'" + "' AND '" + "codigo_Fabricante = '" + product.getManufacturer_code() + "'" + "';";
            crud(query);
        } catch (Exception e) {
            throw e;
        }
    }

    // All Product Names
    public Collection<Product> listProducts() throws Exception {
        try {
            String query = "SELECT * FROM Producto;";
            query_db(query);
            Product product = null;
            Collection<Product> productList = new ArrayList<Product>();
            while (result.next()) {
                product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setManufacturer_code(result.getInt(4));
                productList.add(product);
            }
            db_disconnection();
            return productList;
        } catch (Exception e) {
            db_disconnection();
            throw new Exception("Error de sistema");
        }
    }

    //Product's prices between 120 and 202
    public Collection<Product> searchPricesBetween(int a, int b) throws Exception {
        try {
            String query = "SELECT * FROM Producto"
                    + " WHERE precio BETWEEN " + a + " AND " + b + ";";
            query_db(query);
            Collection<Product> products = new ArrayList<Product>();
            while (result.next()) {
                Product product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setManufacturer_code(result.getInt(4));
                products.add(product);
            }
            db_disconnection();
            return products;
        } catch (Exception e) {
            db_disconnection();
            throw new Exception("Error de sistema");
        }
    }

    //Search PC products
    public Collection<Product> searchPC() throws Exception {
        try {
            String query = "SELECT * FROM producto"
                    + " WHERE nombre LIKE '%portatil%';";
            query_db(query);
            Collection<Product> products = new ArrayList<Product>();
            while (result.next()) {
                Product product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setManufacturer_code(result.getInt(4));
                products.add(product);
            }
            db_disconnection();
            return products;
        } catch (Exception e) {
            db_disconnection();
            throw new Exception("Error de sistema");
        }
    }

    //Cheap Product
    public Product cheapProduct() throws Exception {
        try {
            String query = "SELECT * FROM producto "
                    + "WHERE precio = (SELECT MIN(precio) FROM producto)";
            query_db(query);
            Product product = new Product();
            while (result.next()) {
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setManufacturer_code(result.getInt(4));
            }
            db_disconnection();
            return product;
        } catch (Exception e) {
            db_disconnection();
            throw e;
        }
    }
//Print Product Records

    public Collection<Product> printProduct() throws Exception {
        try {
            String query = "SELECT * FROM producto;";
            query_db(query);
            Collection<Product> products = new ArrayList<Product>();
            while (result.next()) {
                Product product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setManufacturer_code(result.getInt(4));
                products.add(product);
            }
            db_disconnection();
            return products;
        } catch (Exception e) {
            db_Connection();
            throw e;
        }
    }

    //Search product by code
    public Product searchProduct(int code) throws Exception {
        try {
            if (code == 0) {
                throw new Exception("Debe indicar un codigo");
            }
            String query = "SELECT * FROM producto "
                    + "WHERE codigo = '" + code + "'" + ";";
            query_db(query);
            Product product = null;
            while (result.next()) {
                product = new Product();
                product.setCode(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setManufacturer_code(result.getInt(4));
            }
            db_disconnection();
            return product;
        } catch (Exception e) {
            db_disconnection();
            throw e;
        }
    }

}
