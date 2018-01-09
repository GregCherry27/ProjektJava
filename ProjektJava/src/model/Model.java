package model;

public class Model {
    private String name;
    private String product;
    private String accessories;
    private String surface;


    public Model(String name, String product, String accessories, String surface) {
        this.name = name;
        this.product = product;
        this.accessories = accessories;
        this.surface = surface;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getSurface() {
        return surface;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public Model()
    {
        this.name = "";
        this.product = "";
        this.accessories = "";
        this.surface = "";
    }
}
