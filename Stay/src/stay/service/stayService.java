package stay.service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import stay.entity.Stay;
import stay.persistence.StayDAO;

/**
 *
 * @author Exequiel Hordt
 * @version 18 Jan 2023
 */
public class stayService {

    private StayDAO stayDAO;

    public stayService() {
        this.stayDAO = new StayDAO();
    }

    //Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas.
    public void Query10(int client_id, int house_id, String hostName, Date from_date, Date to_date) throws Exception {

        try {

            if (client_id <= 0) {
                throw new Exception("Debe indicar un ID usuario");
            }

            if (house_id <= 0) {
                throw new Exception("Debe indicar un ID casa");
            }

            if (hostName.trim().isEmpty() || hostName == null) {
                throw new Exception("Debe indicar nombre del huesped");
            }

            if (hostName.length() <= 2) {
                throw new Exception("Nombre incorrecto");
            }

            if (from_date == null) {
                throw new Exception("Debe indicar fecha de inicio");
            }

            if (to_date == null) {
                throw new Exception("Debe indicar fecha de cierre");
            }

            Collection<Stay> stays = stayDAO.printRecord();
            for (Stay stay : stays) {
                if (stay.getFrom_date().getDay() == from_date.getDay() && stay.getFrom_date().getMonth() == from_date.getMonth() && stay.getFrom_date().getYear() == from_date.getYear()) {
                    throw new Exception("Conflicto de fechas. Fecha de inicio");
                }
            }

            Stay stay = new Stay();
            stay.setClient_id(client_id);
            stay.setHouse_id(house_id);
            stay.setHostName(hostName);
            stay.setFrom_date(from_date);
            stay.setUntil_date(to_date);
            stayDAO.Query10(stay);

        } catch (Exception e) {

            throw e;

        }

    }

    //Print Records
    public Collection<Stay> printRecord() throws Exception {
        try {

            Collection<Stay> stays = stayDAO.printRecord();
            if (stays.isEmpty() || stays == null) {
                throw new Exception("No existen registros");
            } else {
                for (Stay stay : stays) {
                    System.out.println(stay);
                    System.out.println("");
                }
            }
            return stays;

        } catch (Exception e) {

            throw e;

        }
    }

}
