package net.swimmingtuna.lotm.Client;

public class ClientSpiritualityData {
    private static int playerSpirituality;

    public static void  set(int spirituality) {
        ClientSpiritualityData.playerSpirituality = spirituality;
    }

    public static int getPlayerSpirituality() {
        return playerSpirituality;
    }


}
