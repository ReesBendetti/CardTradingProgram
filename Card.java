import java.util.ArrayList;
import java.util.UUID;
public class Card {
    private String playerFirstName;
    private String playerLastName;
    private String playerPosition;
    private String teamName;
    private String sportsLeague;
    private int cardNumber;
    private String playerTrivia;
    private String rarityType;
    private Boolean isRookie;
    private int numCardsTotal;
    private int numCardsInInventory;
    private UUID id;

    public Card(UUID id, String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, int numCardsTotal, int numCardsInventory) {
        this.playerFirstName = playerFirstName;
        this.playerLastName = playerLastName;
        this.playerPosition = playerPosition;
        this.teamName = teamName;
        this.cardNumber = cardNumber;
        this.playerTrivia = playerTrivia;
        this.rarityType = rarityType;
        this.isRookie = isRookie;
        this.numCardsTotal = numCardsTotal;
        this.numCardsInInventory = numCardsInventory;
        this.id = id;
        

    }

    //deleted player stats -Rees
    public Card(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, int numCardsTotal, int numCardsInventory) {
        this.playerFirstName = playerFirstName;
        this.playerFirstName = playerLastName;
        this.playerPosition = playerPosition;
        this.sportsLeague = sportsLeague;
        this.teamName = teamName;
        this.cardNumber = cardNumber;
        this.playerTrivia = playerTrivia;
        this.rarityType = rarityType;
        this.isRookie = isRookie;
        this.numCardsTotal = numCardsTotal;
        this.numCardsInInventory = numCardsInventory;
        id = UUID.randomUUID();
    }

    public UUID getId(){
        return id;
    }

    public double getValue() {
        return 0.0;
    }
    public User getOwner() {
        User user = new User(id, playerFirstName, playerFirstName, playerFirstName, cardNumber, null);
        return user;
    }
    public String getFirstName() {
        return playerFirstName;
    }
    public String getLastName() {
        return playerLastName;
    }
    public String getPlayerPosition() {
        return playerPosition;
    }
    public String getSportLeague() {
        return sportsLeague;
    }
     /* 
    public static final String CARD_TEAM_NAME = "team-name";
    public static final String CARD_NUMBER = "card-number";
    public static final String CARD_PLAYER_TRIVIA = "plyer-trivia";
    public static final String CARD_RARITY_TYPE = "rarity type";
    public static final String CARD_IS_ROOKIE = "is-rookie";
    public static final String CARD_NUMBER_TOTAL_CARDS = "number-total-cards";
    public static final String CARD_TOTAL_CARD_INVENTORY = "total-cards-inventory"; */
    public String getTeamName() {
        return teamName;
    }
    public int getCardNumber() {
        return cardNumber;
    }
    public String getPlayerTrivia() {
        return playerTrivia;
    }
    public String getRarityType() {
        return rarityType;
    }
    public Boolean isRookie() {
        return true;
    }
    public int getNumberCardsTotal() {
        return numCardsTotal;
    }
    public int getNumberCardsInventory() {
        return numCardsInInventory;
    }

    public String toString(){
        return playerFirstName + " " + playerLastName;
    }
}
