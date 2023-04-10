package ds;

import java.util.HashMap;
import java.util.Map;

public class SmartBuilding {
    private static SmartBuilding smartBuilding = new SmartBuilding();
    private SmartBuilding(){}
    public static SmartBuilding getInstance(){
        return smartBuilding;
    }
    //Temperature is in hours
    private float temperatureDurationTime = 8;
    private float temperature = 25;
    //Time is in hours
    private float lightDurationTime = 8;
    private Map<Integer,String> doorIdToLockStatusMap = new HashMap<>();
    private Map<Integer,String> doorIdToAlarmMap = new HashMap<>();

    public Map<Integer, String> getDoorIdToAlarmMap() {
        return doorIdToAlarmMap;
    }

    public void setDoorIdToAlarmMap(Map<Integer, String> doorIdToAlarmMap) {
        this.doorIdToAlarmMap = doorIdToAlarmMap;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getTemperatureDurationTime() {
        return temperatureDurationTime;
    }

    public void setTemperatureDurationTime(float temperatureDurationTime) {
        this.temperatureDurationTime = temperatureDurationTime;
    }

    public float getLightDurationTime() {
        return lightDurationTime;
    }

    public void setLightDurationTime(float lightDurationTime) {
        this.lightDurationTime = lightDurationTime;
    }

    public Map<Integer, String> getDoorIdToLockStatusMap() {
        return doorIdToLockStatusMap;
    }

    public void setDoorIdToLockStatusMap(Map<Integer, String> doorIdToLockStatusMap) {
        this.doorIdToLockStatusMap = doorIdToLockStatusMap;
    }
}
