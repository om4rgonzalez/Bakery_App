package net.bintelligence.backeryapp.pojo;

import java.util.ArrayList;

public class Elaboration {
    private int elaborationId;
    private String elaborationName;
    private ArrayList<Process> process;
    private ArrayList<Supply> supplies;

    public int getElaborationId() {
        return elaborationId;
    }

    public void setElaborationId(int elaborationId) {
        this.elaborationId = elaborationId;
    }

    public String getElaborationName() {
        return elaborationName;
    }

    public void setElaborationName(String elaborationName) {
        this.elaborationName = elaborationName;
    }

    public ArrayList<Process> getProcess() {
        return process;
    }

    public void setProcess(ArrayList<Process> process) {
        this.process = process;
    }

    public ArrayList<Supply> getSupplies() {
        return supplies;
    }

    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = supplies;
    }
}
