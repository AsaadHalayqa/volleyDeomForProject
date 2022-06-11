package birzeit.edubirzeit.volleydeomforproject.models;

public class Notification {
    private int notificationId;
    private int userInfoId;
    private String descrip;
    private String state;

    public Notification() {
    }

    public Notification(int notificationId, int userInfoId, String descrip, String state) {
        this.notificationId = notificationId;
        this.userInfoId = userInfoId;
        this.descrip = descrip;
        this.state = state;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId +
                ", userInfoId=" + userInfoId +
                ", descrip='" + descrip + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
