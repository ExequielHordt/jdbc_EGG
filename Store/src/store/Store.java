package store;

import store.service.ManufacturerService;
import store.service.ProductService;

/**
 * @author Exequiel Hordt
 * @version 15 Nov 2022
 */
public class Store {

    public static void main(String[] args) {
        ProductService productService = new ProductService();
        ManufacturerService manufacturerService = new ManufacturerService();
        //List Products Names
        /* try {
            System.out.println("Lista de todos los nombres de los productos");
            System.out.println("*******************************************");
            productService.showProductsNames();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en el sistema " + e.getMessage());
        }
         */
 /*
        //List Products Names and Prices
        try {
            System.out.println("Lisa de todos los productos con sus nombres y precios");
            System.out.println("*****************************************************");
            productService.showProductsNamesPrice();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en el sistema " + e.getMessage());
        }
         */
 /*
        //List Products between two prices
        try {
            System.out.println("Lista de todos los productos entre 120 y 202");
            System.out.println("********************************************");
            int a = 120;
            int b = 202;
            productService.searchProductsPricesBetween(a, b);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en el sistema " + e.getMessage());
        }
         */
 /*
        //Search PC 
        try {
            System.out.println("Lista de portatiles");
            System.out.println("*******************");
            productService.searchPC();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de sistema " + e.getMessage());
        }
         */
 /*
        //Cheap Product
        try {
            System.out.println("Producto mas barato");
            System.out.println("*******************");
            productService.cheapProduct();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de sistema " + e.getMessage());
        }
         */
 /*
 //Create Product
        try {
            productService.insertProduct("Soporte Notebook Aluminio Regulable", 20.19, 2);
            productService.printProduct();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de sistema " + e.getMessage());
        }
         */
 /*
        //Create Manufacturer
        try {
            System.out.println("Crear Fabricante");
            System.out.println("****************");
            manufacturerService.createManufacturer("Amazon");
            manufacturerService.printRecords();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de sistema " + e.getMessage());
        }
         */
        //Modified Product 
        try {
            System.out.println("Modificar Producto");
            System.out.println("******************");
            productService.updateProduct(12, "Alexa", 255.78, 10);
            productService.printProduct();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de sistema " + e.getMessage());
        }
    }

}
