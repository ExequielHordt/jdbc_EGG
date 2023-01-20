package stay.service;

import java.time.LocalDate;
import java.util.Collection;
import stay.entity.House;
import stay.persistence.HouseDAO;

/**
 *
 * @author Exequiel Hordt
 * @version 14 Jan 2023
 */
public class houseService {

    private HouseDAO houseDAO;

    public houseService() {
        this.houseDAO = new HouseDAO();
    }

    //Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
    public void Query02() throws Exception {
        try {

            Collection<House> houses = houseDAO.Query02();
            if (houses == null) {
                throw new Exception("No existen registros");
            } else {
                for (House house : houses) {
                    System.out.println(house);
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    //Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico.
    public void Query04(LocalDate from_date, int numberDay) throws Exception {
        try {

            if (from_date == null) {
                throw new Exception("Debe indicar una fecha");
            }
            if (numberDay <= 0) {
                throw new Exception("Debe indicar un numero de dias");
            }
            Collection<House> houses = houseDAO.query04(from_date, numberDay);
            if (houses.isEmpty() || houses == null) {
                throw new Exception("No existen registros");
            } else {
                for (House house : houses) {
                    System.out.println(house);
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            throw e;
        }
    }

    //Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.
    public void Query07() throws Exception {

        try {

            Collection<House> houses = houseDAO.Query07();
            if (houses.isEmpty() || houses == null) {
                throw new Exception("No existen registros");
            } else {
                for (House house : houses) {
                    System.out.println(house);
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            throw e;
        }

    }

    //Obtener el número de casas que existen para cada uno de los países diferentes.
    public void Query08() throws Exception {

        try {

            Collection<String> houses = houseDAO.Query08();
            if (houses.isEmpty() || houses == null) {
                throw new Exception("No existen registros");
            } else {
                for (String house : houses) {
                    System.out.println(house);
                    System.out.println("");
                }
            }

        } catch (Exception e) {

            throw e;

        }

    }

    //Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
    public void Query09() throws Exception {

        try {

            Collection<String> houses = houseDAO.Query09();
            if (houses.isEmpty() || houses == null) {
                throw new Exception("No existen registros");
            } else {
                for (String house : houses) {
                    System.out.println(house);
                    System.out.println("");
                }
            }

        } catch (Exception e) {

            throw e;

        }

    }

}
