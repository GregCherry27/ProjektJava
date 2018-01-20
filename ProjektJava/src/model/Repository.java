package model;

import database.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository extends Database{

    private ObservableList<Model> repModel = FXCollections.observableArrayList();
    private ObservableList<Product> repProduct = FXCollections.observableArrayList();
    private ObservableList<Surface> repSurface = FXCollections.observableArrayList();
    private ObservableList<Accessory> repAccessories = FXCollections.observableArrayList();

    private Repository repo;

    public void setRepository(Repository rep)
    {
         this.repo = rep;
    }

    /*public void loadAll()
    {
        try
        {
            loadProduct();
            loadAccessories();
            loadSurface();
            loadModel();
        } catch(Exception ex)
        {
            System.out.println("Error loadAll(): " + ex);
        }
    }*/


    public void loadProduct() throws SQLException
    {
            try (Connection conn = connectDatabase(); Statement stm = conn.createStatement()) {
                try(ResultSet res = stm.executeQuery("SELECT * FROM `product`")){
                    if(res == null) return;
                    while(res.next())
                    {
                        Product newProduct = new Product();
                        String nameProduct = res.getString("name");
                        newProduct.setName(nameProduct);
                        int temperatureProduct = res.getInt("temperature");
                        newProduct.setTemperature(temperatureProduct);
                        int dosageProduct = res.getInt("dosage");
                        newProduct.setDosage(dosageProduct);
                        repProduct.add(newProduct);
                    }
                }
            }
    }

    public void loadAccessories() throws SQLException
    {
        try (Connection conn = connectDatabase(); Statement stm = conn.createStatement()) {
            try(ResultSet res = stm.executeQuery("SELECT * FROM `accessory`")){
                if(res == null) return;
                while(res.next())
                {
                    Accessory newAccessory = new Accessory();
                    String nameAccessory = res.getString("name");
                    newAccessory.setName(nameAccessory);
                    repAccessories.add(newAccessory);
                }
            }
        }
    }

    public void loadSurface() throws SQLException
    {
        try (Connection conn = connectDatabase(); Statement stm = conn.createStatement()) {
            try(ResultSet res = stm.executeQuery("SELECT * FROM `surface`")){
                if(res == null) return;
                while(res.next())
                {
                    Surface newSurface = new Surface();
                    String nameSurface = res.getString("name");
                    newSurface.setName(nameSurface);
                    String commentsSurface = res.getString("comments");
                    newSurface.setComments(commentsSurface);
                    repSurface.add(newSurface);
                }
            }
        }
    }

    public void loadModel() throws SQLException
    {
        try (Connection conn = connectDatabase(); Statement stm = conn.createStatement()) {
            try(ResultSet res = stm.executeQuery("SELECT * FROM `model`")){
                if(res == null) return;
                while(res.next())
                {
                    Model newModel = new Model();
                    String nameModel = res.getString("name");
                    newModel.setName(nameModel);
                    String productModel = res.getString("surface");
                    newModel.setSurface(productModel);
                    String accessoriesModel = res.getString("accessories");
                    newModel.setAccessories(accessoriesModel);
                    String surfaceModel = res.getString("product");
                    newModel.setProduct(surfaceModel);
                    repModel.add(newModel);
                }
            }
        }
    }

    public  ObservableList<Product> getProduct(){
        ObservableList<Product> pr = FXCollections.observableArrayList();
        try {
            loadProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pr = repProduct;
    }

    public  ObservableList<Accessory> getAccessory(){
        ObservableList<Accessory> ac = FXCollections.observableArrayList();
        try {
            loadAccessories();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ac = repAccessories;
    }

    public  ObservableList<Surface> getSurface(){
        ObservableList<Surface> sr = FXCollections.observableArrayList();
        try {
            loadSurface();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sr = repSurface;
    }

    public  ObservableList<Model> getModel(){
        ObservableList<Model> md = FXCollections.observableArrayList();
        try {
            loadModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return md = repModel;
    }

    public void refreshAccessories()
    {
        repAccessories.clear();
        getAccessory();
    }

    public void refreshProduct()
    {
        repProduct.clear();
        getProduct();
    }

    public void refreshModel()
    {
        repModel.clear();
        getModel();
    }

    public void refreshSurface()
    {
        repSurface.clear();
        getSurface();
    }
}

