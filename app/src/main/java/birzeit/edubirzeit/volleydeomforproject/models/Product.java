package birzeit.edubirzeit.volleydeomforproject.models;

public class Product {
    private int productId;
    private int catId;
    private String productName;
    private String productImage;
    private int price;
    private String descrip;
    private int rateAvg;
    private int rateCounter;
    private int likes;

    public Product() {
    }

    public Product(int productId, int catId, String productName, String productImage,
                   int price, String descrip, int rateAvg, int rateCounter, int likes) {
        this.productId = productId;
        this.catId = catId;
        this.productName = productName;
        this.productImage = productImage;
        this.price = price;
        this.descrip = descrip;
        this.rateAvg = rateAvg;
        this.rateCounter = rateCounter;
        this.likes = likes;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getRateAvg() {
        return rateAvg;
    }

    public void setRateAvg(int rateAvg) {
        this.rateAvg = rateAvg;
    }

    public int getRateCounter() {
        return rateCounter;
    }

    public void setRateCounter(int rateCounter) {
        this.rateCounter = rateCounter;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", catId=" + catId +
                ", productName='" + productName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", price=" + price +
                ", descrip='" + descrip + '\'' +
                ", rateAvg=" + rateAvg +
                ", rateCounter=" + rateCounter +
                ", likes=" + likes +
                '}';
    }
}
