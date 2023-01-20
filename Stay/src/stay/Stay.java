package stay;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import stay.service.clientService;
import stay.service.familyService;
import stay.service.houseService;
import stay.service.stayService;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class Stay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        //MENU
        try {

            Scanner read = new Scanner(System.in).useDelimiter("\n");
            String option;
            familyService family_service = new familyService();
            houseService house_service = new houseService();
            clientService client_service = new clientService();
            stayService stay_service = new stayService();
            LocalDate from_date, to_date;
            int numberDay, day, month, year;
            do {
                System.out.println("Menu");
                System.out.println("****");
                System.out.print("Elija una consulta o presione s para salir"
                        + "\n1)Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años."
                        + "\n2)Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de "
                        + "2020 y el 31 de agosto de 2020 en Reino Unido."
                        + "\n3)Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail."
                        + "\n4)Consulta la BD para que te devuelva aquellas casas disponibles a partir de una fecha dada y un número de días específico."
                        + "\n5)Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron."
                        + "\n6)Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó."
                        + "\n7)Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados."
                        + "\n8)Obtener el número de casas que existen para cada uno de los países diferentes."
                        + "\n9)Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’."
                        + "\n10)Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas."
                        + "\nOpcion seleccionada: ");
                option = read.next();
                switch (option) {
                    case "1":
                        family_service.Query01();
                        break;
                    case "2":
                        house_service.Query02();
                        break;
                    case "3":
                        family_service.Query03();
                        break;
                    case "4":
                        System.out.print("Dia: ");
                        day = read.nextInt();
                        System.out.print("Mes: ");
                        month = read.nextInt();
                        System.out.print("Año: ");
                        year = read.nextInt();
                        from_date = LocalDate.of(year, month, day);
                        System.out.println(from_date);
                        System.out.print("Ingrese numero de dias: ");
                        numberDay = read.nextInt();
                        house_service.Query04(from_date, numberDay);
                        break;
                    case "5":
                        client_service.query05();
                        break;
                    case "6":
                        client_service.Query06();
                        break;
                    case "7":
                        house_service.Query07();
                        break;
                    case "8":
                        house_service.Query08();
                        break;
                    case "9":
                        house_service.Query09();
                        break;
                    case "10":
                        int client_id, house_id;
                        String hostName;
                        System.out.print("ID cliente: ");
                        client_id = read.nextInt();
                        System.out.print("ID casa: ");
                        house_id = read.nextInt();
                        System.out.print("Nombre Huesped: ");
                        hostName = read.next();
                        System.out.println("Fecha de inicio");
                        System.out.println("***************");
                        System.out.print("Dia: ");
                        day = read.nextInt();
                        System.out.print("Mes: ");
                        month = read.nextInt();
                        System.out.print("Año: ");
                        year = read.nextInt();
                        from_date = LocalDate.of(year, month, day);
                        System.out.println("Fecha de cierre");
                        System.out.println("***************");
                        System.out.print("Dia: ");
                        day = read.nextInt();
                        System.out.print("Mes: ");
                        month = read.nextInt();
                        System.out.print("Año: ");
                        year = read.nextInt();
                        to_date = LocalDate.of(year, month, day);
                        Date dateAux01 = java.sql.Date.valueOf(from_date);
                        Date dateAux02 = java.sql.Date.valueOf(to_date);
                        stay_service.Query10(client_id, house_id, hostName, dateAux01, dateAux02);
                        stay_service.printRecord();
                        break;
                    case "s":
                        System.out.println("Saliendo del menu....");
                        break;
                    default:
                        System.out.println("La opcion ingresada no es correcta. Vuelva a intentarlo.");
                        System.out.println("");
                        break;
                }
            } while (!option.equalsIgnoreCase("s"));
            System.out.println("Fin del programa");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error de sistema " + e.getMessage());
        }

    }

}
