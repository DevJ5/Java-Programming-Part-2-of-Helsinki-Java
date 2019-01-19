public class MilitaryService implements NationalService{
    private int daysLeft;

    public MilitaryService(int days) {
        this.daysLeft = days;
    }

    public int getDaysLeft(){
        return daysLeft;
    }

    public void work(){
        if(daysLeft > 0) daysLeft--;
    }
}
