package birzeit.edubirzeit.volleydeomforproject.models;

public class Category {
    private int catId;
    private String catName;
    private String catImage;

    public Category() {
    }

    public Category(int catId, String catName, String catImage) {
        this.catId = catId;
        this.catName = catName;
        this.catImage = catImage;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    @Override
    public String toString() {
        return "Category{" +
                "catId=" + catId +
                ", catName='" + catName + '\'' +
                ", catImage='" + catImage + '\'' +
                '}';
    }
}
