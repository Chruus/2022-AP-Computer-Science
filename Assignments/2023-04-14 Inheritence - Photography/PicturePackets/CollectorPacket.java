public class CollectorPacket extends ChampionPacket {
    private int photoWallets;

    public CollectorPacket() {
        super();
        photoWallets = 8;
    }

    public String getPacketName() {
        return "Collector Packet";
    }

    public String toString() {
        return super.toString() + "\nWallets = " + photoWallets;
    }

}