public class AllStarPacket extends StarterPacket {
    private int photoMagazineCover;
    private int photoTradingCards;

    public AllStarPacket() {
        super();
        photoMagazineCover = 1;
        photoTradingCards = 16;
    }

    public String getPacketName() {
        return "AllStar Packet";
    }

    public String toString() {
        return super.toString() + "\nMagazine = " + photoMagazineCover + "\nCards = " + photoTradingCards;
    }

}