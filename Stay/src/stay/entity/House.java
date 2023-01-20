package stay.entity;

import java.util.Date;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class House {

    private int house_id;
    private String street;
    private int number;
    private String zipCode;
    private String ciy;
    private String country;
    private Date from_date;
    private Date until_date;
    private int time_min;
    private int time_max;
    private Double priceRoom;
    private String kindHouse;

    public House() {
    }

    public House(int house_id, String street, int number, String zipCode, String ciy, String country, Date from_date, Date until_date, int time_min, int time_max, Double priceRoom, String kindHouse) {
        this.house_id = house_id;
        this.street = street;
        this.number = number;
        this.zipCode = zipCode;
        this.ciy = ciy;
        this.country = country;
        this.from_date = from_date;
        this.until_date = until_date;
        this.time_min = time_min;
        this.time_max = time_max;
        this.priceRoom = priceRoom;
        this.kindHouse = kindHouse;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
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

    public String getCiy() {
        return ciy;
    }

    public void setCiy(String ciy) {
        this.ciy = ciy;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getUntil_date() {
        return until_date;
    }

    public void setUntil_date(Date until_date) {
        this.until_date = until_date;
    }

    public int getTime_min() {
        return time_min;
    }

    public void setTime_min(int time_min) {
        this.time_min = time_min;
    }

    public int getTime_max() {
        return time_max;
    }

    public void setTime_max(int time_max) {
        this.time_max = time_max;
    }

    public Double getPriceRoom() {
        return priceRoom;
    }

    public void setPriceRoom(Double priceRoom) {
        this.priceRoom = priceRoom;
    }

    public String getKindHouse() {
        return kindHouse;
    }

    public void setKindHouse(String kindHouse) {
        this.kindHouse = kindHouse;
    }

    @Override
    public String toString() {
        return "House{" + "house_id=" + house_id + ", street=" + street + ", number=" + number + ", zipCode=" + zipCode + ", ciy=" + ciy + ", country=" + country + ", from_date=" + from_date + ", until_date=" + until_date + ", time_min=" + time_min + ", time_max=" + time_max + ", priceRoom=" + priceRoom + ", kindHouse=" + kindHouse + '}';
    }

}
