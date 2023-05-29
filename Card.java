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
    public Card(UUID id, String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, ArrayList<User> users, int numCardsTotal, int numCardsInventory) {
        this.playerFirstName = playerFirstName;
        this.playerFirstName = playerLastName;
        this.playerPosition = playerPosition;
        this.teamName = teamName;
        this.playerStats = playerStats;
        this.cardNumber = cardNumber;
        this.playerTrivia = playerTrivia;
        this.rarityType = rarityType;
        this.isRookie = isRookie;
        this.users = users;
        this.numCardsTotal = numCardsTotal;
        this.numCardsInInventory = numCardsInventory;
        this.id = id;
        

    }

    public Card(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, int numCardsTotal, int numCardsInventory) {
        this.playerFirstName = playerFirstName;
        this.playerFirstName = playerLastName;
        this.playerPosition = playerPosition;
        this.teamName = teamName;
        this.playerStats = playerStats;
        this.cardNumber = cardNumber;
        this.playerTrivia = playerTrivia;
        this.rarityType = rarityType;
        this.isRookie = isRookie;
        this.numCardsTotal = numCardsTotal;
        this.numCardsInInventory = numCardsInventory;
        id = UUID.randomUUID();
    }
    public double getValue() {
        return 0.0;
    }
    public User getOwner() {
        User user = new User(playerFirstName, playerFirstName, playerFirstName);
        return user;
    }
}
