import java.util.ArrayList;
import java.util.UUID;
public class Card {
    private String playerFirstName;
    private String playerLastName;
    private String playerPosition;
    private String teamName;
    private ArrayList<String> playerStats;
    private int cardNumber;
    private String playerTrivia;
    private String rarityType;
    private Boolean isRookie;
    private ArrayList<User> users;
    private int numCardsTotal;
    private int numCardsInInventory;
    private UUID id;
    public Card(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie) {

    }
    public double getValue() {
        return 0.0;
    }
    public User getOwner() {
        return null;
    }
}
