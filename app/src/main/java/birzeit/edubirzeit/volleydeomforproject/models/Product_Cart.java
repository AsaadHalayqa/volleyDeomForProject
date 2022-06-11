package birzeit.edubirzeit.volleydeomforproject.models;

public class Product_Cart {
    private int cartId;
    private int productId;
    private int productConter;

    public Product_Cart() {
    }

    public Product_Cart(int cartId, int productId, int productConter) {
        this.cartId = cartId;
        this.productId = productId;
        this.productConter = productConter;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductConter() {
        return productConter;
    }

    public void setProductConter(int productConter) {
        this.productConter = productConter;
    }

    @Override
    public String toString() {
        return "Product_Cart{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", productConter=" + productConter +
                '}';
    }
}
