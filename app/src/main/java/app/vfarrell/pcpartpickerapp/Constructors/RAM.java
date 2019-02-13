package app.vfarrell.pcpartpickerapp.Constructors;


public class RAM {

    private String ramManufacturer;
    private String ramModel;
    private String ramMemoryType;
    private String ramMemorySize;
    private String ramMemorySpeed;

    public RAM(String ramManufacturer, String ramModel, String ramMemoryType, String ramMemorySize, String ramMemorySpeed) {
        this.ramManufacturer = ramManufacturer;
        this.ramModel = ramModel;
        this.ramMemoryType = ramMemoryType;
        this.ramMemorySize = ramMemorySize;
        this.ramMemorySpeed = ramMemorySpeed;
    }

    public String getRamManufacturer() {
        return ramManufacturer;
    }

    public void setRamManufacturer(String ramManufacturer) {
        this.ramManufacturer = ramManufacturer;
    }

    public String getRamModel() {
        return ramModel;
    }

    public void setRamModel(String ramModel) {
        this.ramModel = ramModel;
    }

    public String getRamMemoryType() {
        return ramMemoryType;
    }

    public void setRamMemoryType(String ramMemoryType) {
        this.ramMemoryType = ramMemoryType;
    }

    public String getRamMemorySize() {
        return ramMemorySize;
    }

    public void setRamMemorySize(String ramMemorySize) {
        this.ramMemorySize = ramMemorySize;
    }

    public String getRamMemorySpeed() {
        return ramMemorySpeed;
    }

    public void setRamMemorySpeed(String ramMemorySpeed) {
        this.ramMemorySpeed = ramMemorySpeed;
    }
}
