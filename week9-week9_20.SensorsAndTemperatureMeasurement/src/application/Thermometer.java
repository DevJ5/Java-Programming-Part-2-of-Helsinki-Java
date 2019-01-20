package application;

public class Thermometer implements Sensor {
    private int temperature;
    private boolean powerOn;

    @Override
    public boolean isOn() {
        return powerOn;
    }

    @Override
    public void on() {
        powerOn = true;
    }

    @Override
    public void off() {
        powerOn = false;
    }

    @Override
    public int measure() {
       if(!powerOn) throw new IllegalStateException("Power is off.");
       temperature = (int)(Math.random() * 60) -30;
       return temperature;
    }
}
