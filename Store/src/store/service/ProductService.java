/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.service;

import java.util.Collection;
import store.entity.Product;
import store.persistence.ProductDAO;

/**
 *
 * @author Exequiel Hordt
 * @version 15 Nov 2022
 */
public class ProductService {

    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    public void insertProduct(String name, Double price, int manufacturer_code) throws Exception {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("Debe indicar un nombre");
            }
            if (price < 0) {
                throw new Exception("El precio debe ser mayor o igual a 0");
            }
            if (manufacturer_code <= 0) {
                throw new Exception("El código del fabricante debe ser un número mayor a 0");
            }
            //Insert Product 
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setManufacturer_code(manufacturer_code);
            productDAO.insertProduct(product);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Product> listProducts() throws Exception {
        try {
            Collection<Product> products = productDAO.listProducts();
            return products;
        } catch (Exception e) {
            throw e;
        }

    }

    public void showProductsNames() throws Exception {
        try {
            Collection<Product> products = listProducts();
            if (products.isEmpty()) {
                throw new Exception("No existe productos para imprimir");
            } else {
                for (Product product : products) {
                    System.out.println(product.getName());
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void showProductsNamesPrice() throws Exception {
        try {
            Collection<Product> products = listProducts();
            if (products.isEmpty()) {
                throw new Exception("No existe productos para imprimir");
            } else {
                for (Product product : products) {
                    System.out.println("Nombre: " + product.getName() + " Precio: " + product.getPrice());
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchProductsPricesBetween(int a, int b) throws Exception {
        try {
            if (a < 0 || b < 0) {
                throw new Exception("Debe indicar numeros enteros positivos");
            }
            Collection<Product> products = productDAO.searchPricesBetween(a, b);
            if (products.isEmpty()) {
                throw new Exception("No existe productos para imprimir");
            } else {
                for (Product product : products) {
                    System.out.println(product);
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void searchPC() throws Exception {
        try {
            Collection<Product> products = productDAO.searchPC();
            if (products.isEmpty()) {
                throw new Exception("No existe productos para imprimir");
            } else {
                for (Product product : products) {
                    System.out.println(product);
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void cheapProduct() throws Exception {
        try {
            Product product = productDAO.cheapProduct();
            if (product == null) {
                throw new Exception("No existe ningun producto para imprimir");
            } else {
                System.out.println(product);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void printProduct() throws Exception {
        try {
            Collection<Product> products = productDAO.printProduct();
            if (products.isEmpty()) {
                throw new Exception("No existe ningun producto a imprimir");
            } else {
                for (Product product : products) {
                    System.out.println(product);
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateProduct(int code, String name, Double price, int manufacturer_code) throws Exception {
        try {
            if (code == 0) {
                throw new Exception("Debe indicar un codigo");
            }
            if (name.trim().isEmpty() || name == null) {
                throw new Exception("Debe indicar un nombre");
            }
            if (price == null || price == 0) {
                throw new Exception("Debe indicar un precio");
            }
            if (manufacturer_code == 0) {
                throw new Exception("Debe indicar un codigo");
            }
            Product product = productDAO.searchProduct(code);
            product.setName(name);
            product.setPrice(price);
            product.setManufacturer_code(manufacturer_code);
            productDAO.updateProduct(product);
        } catch (Exception e) {
            throw e;
        }
    }

}
