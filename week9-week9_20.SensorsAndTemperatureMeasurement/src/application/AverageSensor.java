package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {
    private ArrayList<Sensor> sensors;
    private ArrayList<Integer> measurements;

    public AverageSensor(){
        this.sensors = new ArrayList<Sensor>();
        this.measurements = new ArrayList<Integer>();
    }

    public void addSensor(Sensor additional) {
        sensors.add(additional);
    }

    @Override
    public boolean isOn() {
        Boolean bool = true;
        for (Sensor sensor : sensors) {
            if(!sensor.isOn()) bool = false;
        }
        return bool;
    }

    @Override
    public void on() {
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    @Override
    public void off() {
        for (Sensor sensor : sensors) {
            sensor.off();
        }
    }

    @Override
    public int measure() {
        if(sensors.size() == 0) throw new IllegalStateException("No sensors available.");
        int total = 0;
        for (Sensor sensor : sensors) {
            total += sensor.measure();
        }

        int avg = total / sensors.size();
        measurements.add(avg);

        return avg;
    }

    public List<Integer> readings() {
        return measurements;
    }
}
