package stay.persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import stay.entity.Comment;
import stay.entity.House;

/**
 *
 * @author Exequiel Hordt
 * @version 14 Jan 2023
 */
public class HouseDAO extends DAO {

    //Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
    public Collection<House> Query02() throws Exception {
        try {

            String query = "SELECT * FROM casas "
                    + "WHERE fecha_desde >= '2020-08-01' AND fecha_hasta <= '2020-08-31' AND pais IN ('Reino Unido');";
            queryDB(query);
            Collection<House> houses = new ArrayList<House>();
            while (result.next()) {
                House house = new House();
                house.setHouse_id(result.getInt(1));
                house.setStreet(result.getString(2));
                house.setNumber(result.getInt(3));
                house.setZipCode(result.getString(4));
                house.setCiy(result.getString(5));
                house.setCountry(result.getString(6));
                house.setFrom_date(result.getDate(7));
                house.setUntil_date(result.getDate(8));
                house.setTime_min(result.getInt(9));
                house.setTime_max(result.getInt(10));
                house.setPriceRoom(result.getDouble(11));
                house.setKindHouse(result.getString(12));
                houses.add(house);
            }
            disconnectDB();
            return houses;

        } catch (Exception e) {

            throw e;

        }
    }

    //Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico.
    public Collection<House> query04(LocalDate from_date, int numberDay) throws Exception {
        try {
            String query = "SELECT * FROM casas "
                    + "WHERE fecha_desde <= '" + from_date + "' AND fecha_hasta >= ADDDATE('" + from_date + "', INTERVAL '" + numberDay + "' DAY) "
                    + "AND YEAR(fecha_desde) = '" + from_date.getYear() + "' AND YEAR(fecha_hasta) = '" + from_date.getYear() + "' "
                    + "AND MONTH(fecha_desde) = '" + from_date.getMonthValue() + "' AND MONTH(fecha_hasta) = '" + from_date.getMonthValue() + "' "
                    + "AND tiempo_minimo <= " + numberDay + " AND tiempo_maximo >= '" + numberDay + "';";
            queryDB(query);
            Collection<House> houses = new ArrayList<House>();
            while (result.next()) {
                House house = new House();
                house.setHouse_id(result.getInt(1));
                house.setStreet(result.getString(2));
                house.setNumber(result.getInt(3));
                house.setZipCode(result.getString(4));
                house.setCiy(result.getString(5));
                house.setCountry(result.getString(6));
                house.setFrom_date(result.getDate(7));
                house.setUntil_date(result.getDate(8));
                house.setTime_min(result.getInt(9));
                house.setTime_max(result.getInt(10));
                house.setPriceRoom(result.getDouble(11));
                house.setKindHouse(result.getString(12));
                houses.add(house);
            }
            disconnectDB();
            return houses;
        } catch (Exception e) {
            throw e;
        }
    }

    //Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.
    public Collection<House> Query07() throws Exception {

        try {
            String query = "UPDATE casas "
                    + "SET precio_habitacion = (precio_habitacion * 1.05) "
                    + "WHERE pais = 'Reino Unido'";
            crud(query);
            Collection<House> houses = printRecord();
            return houses;

        } catch (Exception e) {

            throw e;

        } finally {

            disconnectDB();

        }

    }

    public Collection<House> printRecord() throws Exception {

        try {

            String query = "SELECT * FROM casas";
            queryDB(query);
            Collection<House> houses = new ArrayList<House>();
            while (result.next()) {
                House house = new House();
                house.setHouse_id(result.getInt(1));
                house.setStreet(result.getString(2));
                house.setNumber(result.getInt(3));
                house.setZipCode(result.getString(4));
                house.setCiy(result.getString(5));
                house.setCountry(result.getString(6));
                house.setFrom_date(result.getDate(7));
                house.setUntil_date(result.getDate(8));
                house.setTime_min(result.getInt(9));
                house.setTime_max(result.getInt(10));
                house.setPriceRoom(result.getDouble(11));
                house.setKindHouse(result.getString(12));
                houses.add(house);
            }
            disconnectDB();
            return houses;

        } catch (Exception e) {

            throw e;

        }

    }

    //Obtener el número de casas que existen para cada uno de los países diferentes.
    public Collection<String> Query08() throws Exception {

        try {

            String query = "SELECT pais, COUNT(id_casa) FROM casas "
                    + "GROUP BY pais;";
            queryDB(query);
            Collection<String> houses = new ArrayList<String>();
            while (result.next()) {
                House house = new House();
                int numberHouse;
                house.setCountry(result.getString(1));
                numberHouse = result.getInt(2);
                houses.add(house.getCountry() + " Numero de Casas: " + numberHouse);
            }
            disconnectDB();
            return houses;

        } catch (Exception e) {
            throw e;
        }

    }

    //Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
    public Collection<String> Query09() throws Exception {

        try {

            String query = "SELECT casas.*, comentarios.comentario FROM casas "
                    + "INNER JOIN comentarios ON casas.id_casa = comentarios.id_casa "
                    + "WHERE casas.pais = 'Reino Unido' AND comentarios.comentario LIKE '%limpia%';";
            queryDB(query);
            Collection<String> houses = new ArrayList<String>();
            while (result.next()) {              
                House house = new House();
                Comment comment = new Comment();
                house.setHouse_id(result.getInt(1));
                house.setStreet(result.getString(2));
                house.setNumber(result.getInt(3));
                house.setZipCode(result.getString(4));
                house.setCiy(result.getString(5));
                house.setCountry(result.getString(6));
                house.setFrom_date(result.getDate(7));
                house.setUntil_date(result.getDate(8));
                house.setTime_min(result.getInt(9));
                house.setTime_max(result.getInt(10));
                house.setPriceRoom(result.getDouble(11));
                house.setKindHouse(result.getString(12));
                comment.setComment(result.getString(13));
                houses.add(house + " Comentario: " + comment.getComment());
            }
            disconnectDB();
            return houses;

        } catch (Exception e) {
            
            throw e;
            
        }

    }
}
