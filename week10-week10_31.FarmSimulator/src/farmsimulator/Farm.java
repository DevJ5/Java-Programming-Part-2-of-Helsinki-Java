package farmsimulator;

import java.util.ArrayList;
import java.util.Collection;

public class Farm implements Alive {
    private String owner;
    private Barn barn;
    private Collection<Cow> cows;

    public Farm(String name, Barn barn) {
        this.owner = name;
        this.barn = barn;
        this.cows = new ArrayList<Cow>();
    }

    public void addCow(Cow cow) {
        if (cow == null) return;
        cows.add(cow);
    }

    public void liveHour() {
        for (Cow cow : cows) {
            cow.liveHour();
        }
    }

    public void manageCows() {
        barn.takeCareOf(cows);
    }

    public String getOwner() {
        return owner;
    }

    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Farm owner: " + owner + "\n" +
                "Barn bulk tank: " + barn.toString() + "\n" +
                "Animals:" + "\n");
        for (Cow cow : cows) {
            sb.append("        " + cow.toString() + "\n");
        }
        return sb.toString();
    }
}
