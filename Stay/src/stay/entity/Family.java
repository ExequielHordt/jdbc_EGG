package stay.entity;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class Family {

    private int family_id;
    private String name;
    private int age_min;
    private int age_max;
    private int number_children;
    private String email;
    private int houseFamily_id;

    public Family() {
    }

    public Family(int family_id, String name, int age_min, int age_max, int number_children, String email, int houseFamily_id) {
        this.family_id = family_id;
        this.name = name;
        this.age_min = age_min;
        this.age_max = age_max;
        this.number_children = number_children;
        this.email = email;
        this.houseFamily_id = houseFamily_id;
    }

    public int getFamily_id() {
        return family_id;
    }

    public void setFamily_id(int family_id) {
        this.family_id = family_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge_min() {
        return age_min;
    }

    public void setAge_min(int age_min) {
        this.age_min = age_min;
    }

    public int getAge_max() {
        return age_max;
    }

    public void setAge_max(int age_max) {
        this.age_max = age_max;
    }

    public int getNumber_children() {
        return number_children;
    }

    public void setNumber_children(int number_children) {
        this.number_children = number_children;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHouseFamily_id() {
        return houseFamily_id;
    }

    public void setHouseFamily_id(int houseFamily_id) {
        this.houseFamily_id = houseFamily_id;
    }

    @Override
    public String toString() {
        return "Family{" + "family_id=" + family_id + ", name=" + name + ", age_min=" + age_min + ", age_max=" + age_max + ", number_children=" + number_children + ", email=" + email + ", houseFamily_id=" + houseFamily_id + '}';
    }

}
