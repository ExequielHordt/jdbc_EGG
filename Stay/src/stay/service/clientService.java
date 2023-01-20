package stay.service;

import java.util.Collection;
import stay.entity.Client;
import stay.persistence.ClientDAO;

/**
 *
 * @author Exequiel Hordt
 * @version 16 Jan 2023
 */
public class clientService {

    private ClientDAO clientDAO;

    public clientService() {
        this.clientDAO = new ClientDAO();
    }

    //Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
    public void query05() throws Exception {
        try {

            Collection<String> clients = clientDAO.Query05();
            if (clients.isEmpty() || clients == null) {
                throw new Exception("No existen registros");
            } else {
                for (String client : clients) {
                    System.out.println(client);
                    System.out.println("");
                }
            }

        } catch (Exception e) {

            throw e;

        }
    }

    //Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó.
    public void Query06() throws Exception {

        try {

            Collection<String> clients = clientDAO.Query06();
            if (clients.isEmpty() || clients == null) {
                throw new Exception("No existen registros");
            } else {
                for (String client : clients) {
                    System.out.println(client);
                    System.out.println("");
                }
            }

        } catch (Exception e) {
            throw e;
        }

    }
}
