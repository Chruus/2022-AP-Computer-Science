public class ChampionPacket extends AllStarPacket {
    private int photo5x7;

    public ChampionPacket() {
        super();
        photo5x7 = 2;
    }

    public String getPacketName() {
        return "Champion Packet";
    }

    public String toString() {
        return super.toString() + "\n5 x 7 = " + photo5x7;
    }
}