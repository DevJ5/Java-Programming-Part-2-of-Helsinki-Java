package application;

public class ConstantSensor implements Sensor {
   private int temperature;

   public ConstantSensor(int temperature) {
       this.temperature = temperature;
   }

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void on() {

    }

    @Override
    public void off() {

    }

    @Override
    public int measure() {
        return temperature;
    }
}
