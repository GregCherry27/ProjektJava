package model;

public class Product {

    private String name;
    private int temperature;
    private int dosage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getDosage() {
        return dosage;
    }

    public void setDosage(int dosage) {
        this.dosage = dosage;
    }

    public Product(String name, int temperature, int dosage) {
        this.name = name;
        this.temperature = temperature;
        this.dosage = dosage;
    }

    public  Product()
    {
        this.name = "";
        this.temperature = 0;
        this.dosage = 0;
    }
}
