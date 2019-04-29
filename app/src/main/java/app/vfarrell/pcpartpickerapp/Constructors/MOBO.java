package app.vfarrell.pcpartpickerapp.Constructors;


public class MOBO {

    private String moboManufacturer;
    private String moboModel;
    private String moboSocketType;
    private String moboChipset;
    private String moboFormFactor;
    private String moboMemoryType;
    private String moboMemorySlots;
    private String moboMemoryMax;

    public MOBO(String moboManufacturer, String moboModel, String moboSocketType, String moboChipset, String moboFormFactor, String moboMemoryType, String moboMemorySlots, String moboMemoryMax) {
        this.moboManufacturer = moboManufacturer;
        this.moboModel = moboModel;
        this.moboSocketType = moboSocketType;
        this.moboChipset = moboChipset;
        this.moboFormFactor = moboFormFactor;
        this.moboMemoryType = moboMemoryType;
        this.moboMemorySlots = moboMemorySlots;
        this.moboMemoryMax = moboMemoryMax;
    }

    public MOBO() {

    }

    public String getMoboManufacturer() {
        return moboManufacturer;
    }

    public void setMoboManufacturer(String moboManufacturer) {
        this.moboManufacturer = moboManufacturer;
    }

    public String getMoboModel() {
        return moboModel;
    }

    public void setMoboModel(String moboModel) {
        this.moboModel = moboModel;
    }

    public String getMoboSocketType() {
        return moboSocketType;
    }

    public void setMoboSocketType(String moboSocketType) {
        this.moboSocketType = moboSocketType;
    }

    public String getMoboChipset() {
        return moboChipset;
    }

    public void setMoboChipset(String moboChipset) {
        this.moboChipset = moboChipset;
    }

    public String getMoboFormFactor() {
        return moboFormFactor;
    }

    public void setMoboFormFactor(String moboFormFactor) {
        this.moboFormFactor = moboFormFactor;
    }

    public String getMoboMemoryType() {
        return moboMemoryType;
    }

    public void setMoboMemoryType(String moboMemoryType) {
        this.moboMemoryType = moboMemoryType;
    }

    public String getMoboMemorySlots() {
        return moboMemorySlots;
    }

    public void setMoboMemorySlots(String moboMemorySlots) {
        this.moboMemorySlots = moboMemorySlots;
    }

    public String getMoboMemoryMax() {
        return moboMemoryMax;
    }

    public void setMoboMemoryMax(String moboMemoryMax) {
        this.moboMemoryMax = moboMemoryMax;
    }
}
