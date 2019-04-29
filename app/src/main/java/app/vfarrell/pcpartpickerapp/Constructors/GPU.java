package app.vfarrell.pcpartpickerapp.Constructors;


public class GPU {

    private String gpuManufacturer;
    private String gpuModel;
    private String gpuMemory;
    private String gpuClock;
    private String gpuBoost;
    private String gpuSlot;
    private String gpuMemoryType;
    private String gpuTDP;

    public GPU(String gpuManufacturer, String gpuModel, String gpuMemory, String gpuClock, String gpuBoost, String gpuSlot, String gpuMemoryType, String gpuTDP) {
        this.gpuManufacturer = gpuManufacturer;
        this.gpuModel = gpuModel;
        this.gpuMemory = gpuMemory;
        this.gpuClock = gpuClock;
        this.gpuBoost = gpuBoost;
        this.gpuSlot = gpuSlot;
        this.gpuMemoryType = gpuMemoryType;
        this.gpuTDP = gpuTDP;
    }

    public GPU() {
    }

    public String getGpuManufacturer() {
        return gpuManufacturer;
    }

    public void setGpuManufacturer(String gpuManufacturer) {
        this.gpuManufacturer = gpuManufacturer;
    }

    public String getGpuModel() {
        return gpuModel;
    }

    public void setGpuModel(String gpuModel) {
        this.gpuModel = gpuModel;
    }

    public String getGpuMemory() {
        return gpuMemory;
    }

    public void setGpuMemory(String gpuMemory) {
        this.gpuMemory = gpuMemory;
    }

    public String getGpuClock() {
        return gpuClock;
    }

    public void setGpuClock(String gpuClock) {
        this.gpuClock = gpuClock;
    }

    public String getGpuBoost() {
        return gpuBoost;
    }

    public void setGpuBoost(String gpuBoost) {
        this.gpuBoost = gpuBoost;
    }

    public String getGpuSlot() {
        return gpuSlot;
    }

    public void setGpuSlot(String gpuSlot) {
        this.gpuSlot = gpuSlot;
    }

    public String getGpuMemoryType() {
        return gpuMemoryType;
    }

    public void setGpuMemoryType(String gpuMemoryType) {
        this.gpuMemoryType = gpuMemoryType;
    }

    public String getGpuTDP() {
        return gpuTDP;
    }

    public void setGpuTDP(String gpuTDP) {
        this.gpuTDP = gpuTDP;
    }
}