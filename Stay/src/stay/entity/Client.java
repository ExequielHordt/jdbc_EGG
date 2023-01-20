package stay.entity;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class Client {

    private int client_id;
    private String name;
    private String street;
    private int number;
    private String zipCode;
    private String city;
    private String country;
    private String email;

    public Client() {
    }

    public Client(int client_id, String name, String street, int number, String zipCode, String city, String country, String email) {
        this.client_id = client_id;
        this.name = name;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
        this.email = email;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" + "client_id=" + client_id + ", name=" + name + ", street=" + street + ", number=" + number + ", zipCode=" + zipCode + ", city=" + city + ", country=" + country + ", email=" + email + '}';
    }

}
