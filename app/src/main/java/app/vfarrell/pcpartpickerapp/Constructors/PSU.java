package app.vfarrell.pcpartpickerapp.Constructors;


public class PSU {

    private String psuManufacturer;
    private String psuModel;
    private String psuWattage;
    private String psuFormFactor;
    private String psuEfficCert;
    private String psuPwrPins;

    public PSU(String psuManufacturer, String psuModel, String psuWattage, String psuFormFactor, String psuEfficCert, String psuPwrPins) {
        this.psuManufacturer = psuManufacturer;
        this.psuModel = psuModel;
        this.psuWattage = psuWattage;
        this.psuFormFactor = psuFormFactor;
        this.psuEfficCert = psuEfficCert;
        this.psuPwrPins = psuPwrPins;
    }

    public String getPsuManufacturer() {
        return psuManufacturer;
    }

    public void setPsuManufacturer(String psuManufacturer) {
        this.psuManufacturer = psuManufacturer;
    }

    public String getPsuModel() {
        return psuModel;
    }

    public void setPsuModel(String psuModel) {
        this.psuModel = psuModel;
    }

    public String getPsuWattage() {
        return psuWattage;
    }

    public void setPsuWattage(String psuWattage) {
        this.psuWattage = psuWattage;
    }

    public String getPsuFormFactor() {
        return psuFormFactor;
    }

    public void setPsuFormFactor(String psuFormFactor) {
        this.psuFormFactor = psuFormFactor;
    }

    public String getPsuEfficCert() {
        return psuEfficCert;
    }

    public void setPsuEfficCert(String psuEfficCert) {
        this.psuEfficCert = psuEfficCert;
    }

    public String getPsuPwrPins() {
        return psuPwrPins;
    }

    public void setPsuPwrPins(String psuPwrPins) {
        this.psuPwrPins = psuPwrPins;
    }
}
