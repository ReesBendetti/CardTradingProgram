import java.util.ArrayList;
import java.util.List;

public class CardInventory {
    private ArrayList<Card> cards;
    private static CardInventory Inventory;
    private CardInventory() {

    }
    public static CardInventory getInstance() {
        CardInventory inventory = new CardInventory();
        return inventory;
    }
    public boolean addCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie) {
        return true;
    }
    public void removeCard(Card card) {

    }
    public List<Card> searchPlayer(String firstName, String lastName) {
        return cards;
    }

}
