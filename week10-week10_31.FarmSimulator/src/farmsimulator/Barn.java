package farmsimulator;

import java.util.Collection;

public class Barn {
    private BulkTank bulkTank;
    private MilkingRobot milkingRobot;

    public Barn (BulkTank tank) {
        this.bulkTank = tank;
    }

    public BulkTank getBulkTank() {
        return bulkTank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot) {
        this.milkingRobot = milkingRobot;
        milkingRobot.setBulkTank(bulkTank);
    }

    public void takeCareOf(Cow cow) {
        try {
            milkingRobot.milk(cow);
        } catch (Exception e) {
            throw new IllegalStateException("Milking robot is not available.");
        }
    }

    public void takeCareOf(Collection<Cow> cows) {
        for (Cow cow : cows) {
            takeCareOf(cow);
        }
    }

    @Override
    public String toString() {
        return bulkTank.toString();
    }
}
