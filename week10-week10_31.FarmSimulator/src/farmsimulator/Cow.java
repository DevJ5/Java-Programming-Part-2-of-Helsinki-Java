package farmsimulator;

import java.util.Random;

public class Cow implements Alive, Milkable{
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    private Random random = new Random();
    private String name;
    private double udderCapacity;
    private double amountOfMilk;

    public Cow() {
        this(NAMES[new Random().nextInt(NAMES.length)]);
    }

    public Cow (String name) {
        this.name = name;
        this.udderCapacity = 15 + new Random().nextInt(26);
    }

    public String getName() {
        return name;
    }

    public double getCapacity() {
        return udderCapacity;
    }

    public double getAmount () {
        return amountOfMilk;
    }

    @Override
    public String toString() {
        return name + " " + Math.ceil(amountOfMilk) + "/" + Math.ceil(udderCapacity);
    }

    public void liveHour() {
        double milk = 0.7 + (2-0.7) * random.nextDouble();
        if(amountOfMilk + milk >= udderCapacity) amountOfMilk = udderCapacity;
        else amountOfMilk += milk;
    }

    public double milk() {
        double milkToBeProcessed = amountOfMilk;
        amountOfMilk = 0;
        return milkToBeProcessed;
    }
}
