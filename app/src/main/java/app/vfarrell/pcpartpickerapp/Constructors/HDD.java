package app.vfarrell.pcpartpickerapp.Constructors;


public class HDD {

    private String hddManufacturer;
    private String hddModel;
    private String hddFormFactor;
    private String hddStorage;
    private String hddRPM;

    public HDD(String hddManufacturer, String hddModel, String hddFormFactor, String hddStorage, String hddRPM) {
        this.hddManufacturer = hddManufacturer;
        this.hddModel = hddModel;
        this.hddFormFactor = hddFormFactor;
        this.hddStorage = hddStorage;
        this.hddRPM = hddRPM;
    }

    public String getHddManufacturer() {
        return hddManufacturer;
    }

    public void setHddManufacturer(String hddManufacturer) {
        this.hddManufacturer = hddManufacturer;
    }

    public String getHddModel() {
        return hddModel;
    }

    public void setHddModel(String hddModel) {
        this.hddModel = hddModel;
    }

    public String getHddFormFactor() {
        return hddFormFactor;
    }

    public void setHddFormFactor(String hddFormFactor) {
        this.hddFormFactor = hddFormFactor;
    }

    public String getHddStorage() {
        return hddStorage;
    }

    public void setHddStorage(String hddStorage) {
        this.hddStorage = hddStorage;
    }

    public String getHddRPM() {
        return hddRPM;
    }

    public void setHddRPM(String hddRPM) {
        this.hddRPM = hddRPM;
    }
}
