package idhackathon.com.idhackathon.items;

/**
 * Created by Kim on 2016-05-28.
 */
public class ScheduleItem {
    int id;
    String time;
    String msg;
    String type;

    public ScheduleItem() {
        this.id = 0;
        this.time = "";
        this.msg = "";
        this.type = "";
    }

    public ScheduleItem(int id,String time, String msg, String type) {
        this.id = id;
        this.time = time;
        this.msg = msg;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}