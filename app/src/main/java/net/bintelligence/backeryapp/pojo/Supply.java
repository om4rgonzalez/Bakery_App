package net.bintelligence.backeryapp.pojo;

public class Supply {
    private int supplyId;
    private String supplyName;
    private String measureUnit;
    private String measureValue;
    private String newMeasureValue;

    public String getNewMeasureValue() {
        return newMeasureValue;
    }

    public void setNewMeasureValue(String newMeasureValue) {
        this.newMeasureValue = newMeasureValue;
    }

    public int getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(int supplyId) {
        this.supplyId = supplyId;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getMeasureUnit() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit = measureUnit;
    }

    public String getMeasureValue() {
        return measureValue;
    }

    public void setMeasureValue(String measureValue) {
        this.newMeasureValue = measureValue;
        this.measureValue = measureValue;
    }
}
