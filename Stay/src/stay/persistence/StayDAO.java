package stay.persistence;

import java.util.ArrayList;
import java.util.Collection;
import stay.entity.Stay;

/**
 *
 * @author Exequiel Hordt
 * @version 18 Jan 2023
 */
public class StayDAO extends DAO {

    //Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
    public void Query10(Stay stay) throws Exception {

        try {

            if (stay == null) {
                throw new Exception("Debe indicar un estancia");
            }

            String query = "INSERT INTO estancias (id_cliente,id_casa,nombre_huesped,fecha_desde,fecha_hasta)"
                    + "Values('" + stay.getClient_id() + "', '" + stay.getHouse_id() + "', '" + stay.getHostName() + "', '" + stay.getFrom_date() + "', '" + stay.getUntil_date() + "');";
            crud(query);

        } catch (Exception e) {

            throw e;

        } finally {

            disconnectDB();

        }

    }

    //Print Records
    public Collection<Stay> printRecord() throws Exception {

        try {

            String query = "SELECT * FROM estancias";
            queryDB(query);
            Collection<Stay> stays = new ArrayList<Stay>();
            while (result.next()) {
                Stay stay = new Stay();
                stay.setStay_id(result.getInt(1));
                stay.setClient_id(result.getInt(2));
                stay.setHouse_id(result.getInt(3));
                stay.setHostName(result.getString(4));
                stay.setFrom_date(result.getDate(5));
                stay.setUntil_date(result.getDate(6));
                stays.add(stay);
            }
            disconnectDB();
            return stays;

        } catch (Exception e) {

            throw e;

        }

    }

}
