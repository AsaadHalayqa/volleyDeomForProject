package birzeit.edubirzeit.volleydeomforproject.models;

public class Rate {
    private int rateId;
    private int userInfoId;
    private int productId;
    private int rateOfProduct;

    public Rate() {
    }

    public Rate(int rateId, int userInfoId, int productId, int rateOfProduct) {
        this.rateId = rateId;
        this.userInfoId = userInfoId;
        this.productId = productId;
        this.rateOfProduct = rateOfProduct;
    }

    public int getRateId() {
        return rateId;
    }

    public void setRateId(int rateId) {
        this.rateId = rateId;
    }

    public int getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        this.userInfoId = userInfoId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getRateOfProduct() {
        return rateOfProduct;
    }

    public void setRateOfProduct(int rateOfProduct) {
        this.rateOfProduct = rateOfProduct;
    }

    @Override
    public String toString() {
        return "Rate{" +
                "rateId=" + rateId +
                ", userInfoId=" + userInfoId +
                ", productId=" + productId +
                ", rateOfProduct=" + rateOfProduct +
                '}';
    }
}
