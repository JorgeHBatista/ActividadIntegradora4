package film;

// Este sería el modelo en un MVC
public class Film {

    private final String title;
    private final int spectators;
    private final int roomsBroadcast;
    private double grossProfit;
    private double netProfit;

    public Film(String title, int spectators, int roomsBroadcast) {
        this.title = title;
        this.spectators = spectators;
        this.roomsBroadcast = roomsBroadcast;
    }

    public String getTitle() {
        return title;
    }

    public int getSpectators() {
        return spectators;
    }

    public int getRoomsBroadcast() {
        return roomsBroadcast;
    }

    public double getGrossProfit() {
        return grossProfit;
    }

    public double getNetProfit() {
        return netProfit;
    }

    private void setNetProfit(double netProfit) {
        this.netProfit = netProfit;
    }

    public void computeGrossProfit() {
        this.grossProfit = this.getSpectators() * this.getRoomsBroadcast();
    }

    public void computeNetProfit() {
        this.setNetProfit(this.getGrossProfit() * 0.8);
    }

    @Override
    public String toString() {
        return  "Film {" + this.getTitle() +
                ", Spectators per room: " + this.getSpectators() +
                ", Rooms broadcast: " + this.getRoomsBroadcast() +
                ", Gross profit: " + this.getGrossProfit() +
                ", Net profit: " + this.getNetProfit() + "}";
    }
}
