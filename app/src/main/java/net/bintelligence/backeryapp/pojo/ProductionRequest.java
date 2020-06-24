package net.bintelligence.backeryapp.pojo;

import java.util.ArrayList;

public class ProductionRequest {
    private ArrayList<Supply> supplies;
    private double quantity;
    private Product product;

    public ProductionRequest(ArrayList<Supply> supplies, double quantity, Product product) {
        this.supplies = supplies;
        this.quantity = quantity;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = supplies;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
