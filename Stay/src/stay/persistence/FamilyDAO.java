package stay.persistence;

import java.util.ArrayList;
import java.util.Collection;
import stay.entity.Family;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class FamilyDAO extends DAO {

    //Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
    public Collection<Family> Query02() throws Exception {
        try {

            String query = "SELECT * FROM familias"
                    + " WHERE num_hijos >= 3 AND edad_maxima < 10;";
            queryDB(query);
            Collection<Family> families = new ArrayList<Family>();
            Family family = null;
            while (result.next()) {
                family = new Family();
                family.setFamily_id(result.getInt(1));
                family.setName(result.getString(2));
                family.setAge_min(result.getInt(3));
                family.setAge_max(result.getInt(4));
                family.setNumber_children(result.getInt(5));
                family.setEmail(result.getString(6));
                family.setHouseFamily_id(result.getInt(7));
                families.add(family);
            }
            disconnectDB();
            return families;

        } catch (Exception e) {

            throw e;

        }
    }

    //Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
    public Collection<Family> Query03() throws Exception {
        try {
            String query = "SELECT * FROM familias "
                    + "WHERE email LIKE '%Hotmail%';";
            queryDB(query);
            Collection<Family> families = new ArrayList<Family>();

            while (result.next()) {
                Family family = new Family();
                family.setFamily_id(result.getInt(1));
                family.setName(result.getString(2));
                family.setAge_min(result.getInt(3));
                family.setAge_max(result.getInt(4));
                family.setNumber_children(result.getInt(5));
                family.setEmail(result.getString(6));
                family.setHouseFamily_id(result.getInt(7));
                families.add(family);
            }
            disconnectDB();
            return families;
        } catch (Exception e) {
            throw e;
        }
    }

}
