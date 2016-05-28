package idhackathon.com.idhackathon.items;

/**
 * Created by Kim on 2016-05-28.
 */
public class ScheduleItem {
    String time;
    String msg;
    String type;

    public ScheduleItem(String time) {
        this.time = time;
        this.msg = "";
        this.type = "";
    }

    public ScheduleItem(String time, String msg, String type) {
        this.time = time;
        this.msg = msg;
        this.type = type;
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