package com.solutions.servermanager.models;

public abstract class AbstractMachine {

    private int cpu;
    private int ram;
    private int hdd;

    public AbstractMachine(int cpu, int ram, int hdd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    @Override
    public String toString() {
        return "AbstractMachine{" +
                "cpu=" + cpu +
                ", ram=" + ram +
                ", hdd=" + hdd +
                '}';
    }
}
