package birzeit.edubirzeit.volleydeomforproject.models;

public class Ordered {
    private int orderedId;
    private int cartId;
    private int price;
    private String state;
    private String location;

    public Ordered() {
    }

    public Ordered(int orderedId, int cartId, int price, String state, String location) {
        this.orderedId = orderedId;
        this.cartId = cartId;
        this.price = price;
        this.state = state;
        this.location = location;
    }

    public int getOrderedId() {
        return orderedId;
    }

    public void setOrderedId(int orderedId) {
        this.orderedId = orderedId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Ordered{" +
                "orderedId=" + orderedId +
                ", cartId=" + cartId +
                ", price=" + price +
                ", state='" + state + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
