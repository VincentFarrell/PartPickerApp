package app.vfarrell.pcpartpickerapp.Constructors;


public class SSD {

    private String ssdManufacturer;
    private String ssdModel;
    private String ssdFormFactor;
    private String ssdStorage;

    public SSD(String ssdManufacturer, String ssdModel, String ssdFormFactor, String ssdStorage) {
        this.ssdManufacturer = ssdManufacturer;
        this.ssdModel = ssdModel;
        this.ssdFormFactor = ssdFormFactor;
        this.ssdStorage = ssdStorage;
    }

    public String getSsdManufacturer() {
        return ssdManufacturer;
    }

    public void setSsdManufacturer(String ssdManufacturer) {
        this.ssdManufacturer = ssdManufacturer;
    }

    public String getSsdModel() {
        return ssdModel;
    }

    public void setSsdModel(String ssdModel) {
        this.ssdModel = ssdModel;
    }

    public String getSsdFormFactor() {
        return ssdFormFactor;
    }

    public void setSsdFormFactor(String ssdFormFactor) {
        this.ssdFormFactor = ssdFormFactor;
    }

    public String getSsdStorage() {
        return ssdStorage;
    }

    public void setSsdStorage(String ssdStorage) {
        this.ssdStorage = ssdStorage;
    }
}

