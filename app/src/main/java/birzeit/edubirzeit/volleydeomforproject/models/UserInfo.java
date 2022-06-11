package birzeit.edubirzeit.volleydeomforproject.models;

public class UserInfo {

    private int userInfoId;
    private String firstName;
    private String lastName;
    private String phoneNum;
    private String userPassword;
    private String userRole;
    private String email;
    private int points;
    private String address;

    public UserInfo() {
    }

    public UserInfo(int userInfoId, String firstName, String lastName,
                    String phoneNum, String userPassword, String userRole, String email,
                    int points, String address) {
        this.userInfoId = userInfoId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.userPassword = userPassword;
        this.userRole = userRole;
        this.email = email;
        this.points = points;
        this.address = address;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userInfoId=" + userInfoId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole='" + userRole + '\'' +
                ", email='" + email + '\'' +
                ", points=" + points +
                ", address='" + address + '\'' +
                "}\n\n";
    }

}
