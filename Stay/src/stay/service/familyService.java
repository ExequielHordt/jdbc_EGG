/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stay.service;

import java.util.Collection;
import stay.entity.Family;
import stay.persistence.FamilyDAO;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class familyService {

    private FamilyDAO familyDAO;

    public familyService() {
        this.familyDAO = new FamilyDAO();
    }

    //Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
    public void Query01() throws Exception {
        try {
            Collection<Family> families = familyDAO.Query02();
            if (families == null) {
                throw new Exception("No hay registros para mostrar");
            } else {
                for (Family family : families) {
                    System.out.println(family);
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    //Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
    public void Query03() throws Exception{
        try {
            Collection<Family> families = familyDAO.Query03();
            if(families == null){
            throw new Exception("No existen registros");
            } else {
                for (Family family : families) {
                    System.out.println(family);
                    System.out.println("");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
