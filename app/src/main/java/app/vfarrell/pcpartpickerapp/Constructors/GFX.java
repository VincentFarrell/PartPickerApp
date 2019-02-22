package app.vfarrell.pcpartpickerapp.Constructors;


public class GFX {

    private String gfxManufacturer;
    private String gfxModel;
    private String gfxMemorySize;
    private String gfxClockSpeed;
    private String gfxClockBoost;
    private String gfxTDP;
    private String gfxDualSupport;

    public GFX(String gfxManufacturer, String gfxModel, String gfxMemorySize, String gfxClockSpeed, String gfxClockBoost, String gfxTDP, String gfxDualSupport) {
        this.gfxManufacturer = gfxManufacturer;
        this.gfxModel = gfxModel;
        this.gfxMemorySize = gfxMemorySize;
        this.gfxClockSpeed = gfxClockSpeed;
        this.gfxClockBoost = gfxClockBoost;
        this.gfxTDP = gfxTDP;
        this.gfxDualSupport = gfxDualSupport;
    }

    public String getGfxManufacturer() {
        return gfxManufacturer;
    }

    public void setGfxManufacturer(String gfxManufacturer) {
        this.gfxManufacturer = gfxManufacturer;
    }

    public String getGfxModel() {
        return gfxModel;
    }

    public void setGfxModel(String gfxModel) {
        this.gfxModel = gfxModel;
    }

    public String getGfxMemorySize() {
        return gfxMemorySize;
    }

    public void setGfxMemorySize(String gfxMemorySize) {
        this.gfxMemorySize = gfxMemorySize;
    }

    public String getGfxClockSpeed() {
        return gfxClockSpeed;
    }

    public void setGfxClockSpeed(String gfxClockSpeed) {
        this.gfxClockSpeed = gfxClockSpeed;
    }

    public String getGfxClockBoost() {
        return gfxClockBoost;
    }

    public void setGfxClockBoost(String gfxClockBoost) {
        this.gfxClockBoost = gfxClockBoost;
    }

    public String getGfxTDP() {
        return gfxTDP;
    }

    public void setGfxTDP(String gfxTDP) {
        this.gfxTDP = gfxTDP;
    }

    public String getGfxDualSupport() {
        return gfxDualSupport;
    }

    public void setGfxDualSupport(String gfxDualSupport) {
        this.gfxDualSupport = gfxDualSupport;
    }
}
