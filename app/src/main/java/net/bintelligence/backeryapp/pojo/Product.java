package net.bintelligence.backeryapp.pojo;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private int productId;
    private String productName;
    private String description;
    private ArrayList<Elaboration> elaborations;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Elaboration> getElaborations() {
        return elaborations;
    }

    public void setElaborations(ArrayList<Elaboration> elaborations) {
        this.elaborations = elaborations;
    }
}
