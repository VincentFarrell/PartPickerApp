package app.vfarrell.pcpartpickerapp.Constructors;

public class CPU {

    private String cpuManufacturer;
    private String cpuModel;
    private String cpuCores;
    private String cpuClock;
    private String cpuBoost;
    private String cpuSocket;
    private String cpuMemory;
    private String cpuTDP;

    public CPU(String cpuManufacturer, String cpuModel, String cpuCores, String cpuClock, String cpuBoost, String cpuSocket, String cpuMemory, String cpuTDP) {
        this.cpuManufacturer = cpuManufacturer;
        this.cpuModel = cpuModel;
        this.cpuCores = cpuCores;
        this.cpuClock = cpuClock;
        this.cpuBoost = cpuBoost;
        this.cpuSocket = cpuSocket;
        this.cpuMemory = cpuMemory;
        this.cpuTDP = cpuTDP;
    }

    public String getCpuManufacturer() {
        return cpuManufacturer;
    }

    public void setCpuManufacturer(String cpuManufacturer) {
        this.cpuManufacturer = cpuManufacturer;
    }

    public String getCpuModel() {
        return cpuModel;
    }

    public void setCpuModel(String cpuModel) {
        this.cpuModel = cpuModel;
    }

    public String getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(String cpuCores) {
        this.cpuCores = cpuCores;
    }

    public String getCpuClock() {
        return cpuClock;
    }

    public void setCpuClock(String cpuClock) {
        this.cpuClock = cpuClock;
    }

    public String getCpuBoost() {
        return cpuBoost;
    }

    public void setCpuBoost(String cpuBoost) {
        this.cpuBoost = cpuBoost;
    }

    public String getCpuSocket() {
        return cpuSocket;
    }

    public void setCpuSocket(String cpuSocket) {
        this.cpuSocket = cpuSocket;
    }

    public String getCpuMemory() {
        return cpuMemory;
    }

    public void setCpuMemory(String cpuMemory) {
        this.cpuMemory = cpuMemory;
    }

    public String getCpuTDP() {
        return cpuTDP;
    }

    public void setCpuTDP(String cpuTDP) {
        this.cpuTDP = cpuTDP;
    }
}
