package birzeit.edubirzeit.volleydeomforproject.models;

public class Cart {
    private int cartId;
    private int userInfoId;
    private String state;

    public Cart() {
    }

    public Cart(int cartId, int userInfoId, String state) {
        this.cartId = cartId;
        this.userInfoId = userInfoId;
        this.state = state;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", userInfoId=" + userInfoId +
                ", state='" + state + '\'' +
                '}';
    }
}
