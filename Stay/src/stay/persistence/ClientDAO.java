package stay.persistence;

import java.util.ArrayList;
import java.util.Collection;
import stay.entity.Client;
import stay.entity.Comment;
import stay.entity.House;
import stay.entity.Stay;

/**
 *
 * @author Exequiel Hordt
 * @version 16 Jan 2023
 */
public class ClientDAO extends DAO {

    //Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
    public Collection<String> Query05() throws Exception {
        try {

            String query = "SELECT clientes.*, comentarios.comentario FROM clientes "
                    + "INNER JOIN estancias ON clientes.id_cliente = estancias.id_cliente "
                    + "INNER JOIN casas ON estancias.id_casa = casas.id_casa "
                    + "INNER JOIN comentarios ON casas.id_casa = comentarios.id_casa "
                    + "GROUP BY clientes.id_cliente;";
            queryDB(query);
            Collection<String> clients = new ArrayList<String>();
            while (result.next()) {
                Client client = new Client();
                Comment comment = new Comment();
                client.setClient_id(result.getInt(1));
                client.setName(result.getString(2));
                client.setStreet(result.getString(3));
                client.setNumber(result.getInt(4));
                client.setZipCode(result.getString(5));
                client.setCity(result.getString(6));
                client.setCountry(result.getString(7));
                client.setEmail(result.getString(8));
                comment.setComment(result.getString(9));
                clients.add(client + " Comentario: " + comment.getComment());
            }
            disconnectDB();
            return clients;

        } catch (Exception e) {
            throw e;
        }
    }

    //Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó.
    public Collection<String> Query06() throws Exception {
        try {

            String query = "SELECT estancias.*, clientes.pais, clientes.ciudad, casas.* FROM estancias "
                    + "INNER JOIN clientes ON estancias.id_cliente = clientes.id_cliente "
                    + "INNER JOIN casas ON estancias.id_casa = casas.id_casa "
                    + "GROUP BY estancias.id_cliente";
            queryDB(query);
            Collection<String> clients = new ArrayList<String>();
            while (result.next()) {
                Stay stay = new Stay();
                Client client = new Client();
                House house = new House();
                stay.setStay_id(result.getInt(1));
                stay.setClient_id(result.getInt(2));
                stay.setHouse_id(result.getInt(3));
                stay.setHostName(result.getString(4));
                stay.setFrom_date(result.getDate(5));
                stay.setUntil_date(result.getDate(6));
                client.setCountry(result.getString(7));
                client.setCity(result.getString(8));
                house.setHouse_id(result.getInt(9));
                house.setStreet(result.getString(10));
                house.setNumber(result.getInt(11));
                house.setZipCode(result.getString(12));
                house.setCiy(result.getString(13));
                house.setCountry(result.getString(14));
                house.setFrom_date(result.getDate(15));
                house.setUntil_date(result.getDate(16));
                house.setTime_min(result.getInt(17));
                house.setTime_max(result.getInt(18));
                house.setPriceRoom(result.getDouble(19));
                house.setKindHouse(result.getString(20));
                clients.add(stay + " Pais: " + client.getCountry() + " Ciudad: " + client.getCity() + " " + house);
            }
            disconnectDB();
            return clients;

        } catch (Exception e) {
            throw e;
        }
    }
}
