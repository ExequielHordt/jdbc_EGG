package stay.entity;

/**
 *
 * @author Exequiel Hordt
 * @version 13 Jan 2023
 */
public class Comment {

    private int comment_id;
    private int house_id;
    private String comment;

    public Comment() {
    }

    public Comment(int comment_id, int house_id, String comment) {
        this.comment_id = comment_id;
        this.house_id = house_id;
        this.comment = comment;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public int getHouse_id() {
        return house_id;
    }

    public void setHouse_id(int house_id) {
        this.house_id = house_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" + "comment=" + comment + '}';
    }

}
