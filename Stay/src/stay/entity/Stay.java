package stay.entity;

import java.util.Date;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class Stay {

    private int stay_id;
    private int client_id;
    private int house_id;
    private String hostName;
    private Date from_date;
    private Date until_date;

    public Stay() {
    }

    public Stay(int stay_id, int client_id, int house_id, String hostName, Date from_date, Date until_date) {
        this.stay_id = stay_id;
        this.client_id = client_id;
        this.house_id = house_id;
        this.hostName = hostName;
        this.from_date = from_date;
        this.until_date = until_date;
    }

    public int getStay_id() {
        return stay_id;
    }

    public void setStay_id(int stay_id) {
        this.stay_id = stay_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
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

    @Override
    public String toString() {
        return "Stay{" + "stay_id=" + stay_id + ", client_id=" + client_id + ", house_id=" + house_id + ", hostName=" + hostName + ", from_date=" + from_date + ", until_date=" + until_date + '}';
    }

}
