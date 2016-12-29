package project.carRental.entity;

/**
 * This class describes the entity Equipment
 *
 * @author Yuriy Kolennikov
 */

public class Equipment extends BasicEntity {
    private String equipment;
    private String transmission;
    private String leatherInterior;
    private String electroPackage;
    private String airConditioning;
    private String voiceControl;

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getLeatherInterior() {
        return leatherInterior;
    }

    public void setLeatherInterior(String leatherInterior) {
        this.leatherInterior = leatherInterior;
    }

    public String getElectroPackage() {
        return electroPackage;
    }

    public void setElectroPackage(String electroPackage) {
        this.electroPackage = electroPackage;
    }

    public String getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(String airConditioning) {
        this.airConditioning = airConditioning;
    }

    public String getVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(String voiceControl) {
        this.voiceControl = voiceControl;
    }

    @Override
    public String toString() {
        return super.toString() + equipment + ": "
                + transmission + " "
                + leatherInterior + " "
                + electroPackage + " "
                + airConditioning + " "
                + voiceControl + "\n";

    }


}
