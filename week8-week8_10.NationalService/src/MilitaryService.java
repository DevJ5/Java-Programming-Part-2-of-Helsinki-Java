public class MilitaryService implements NationalService{
    private int daysLeft;

    public MilitaryService(int days) {
        this.daysLeft = days;
    }

    @Override
    public int getDaysLeft() {
        return daysLeft;
    }

    @Override
    public void work() {
        if(daysLeft != 0) daysLeft--;
    }
}
