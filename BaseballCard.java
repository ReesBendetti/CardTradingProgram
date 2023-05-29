import java.util.ArrayList;
import java.util.UUID;
public class BaseballCard extends Card{
<<<<<<< HEAD
    public BaseballCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String companyInfo) {
        super(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, companyInfo, null, null, cardNumber, cardNumber);
=======
    public BaseballCard(UUID id, String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, ArrayList<User> users, int numCardsTotal, int numCardsInventory) {
        super(id, playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, rarityType, isRookie, users, numCardsTotal, numCardsInventory);
        
>>>>>>> 799b4046453422d1f84eaa8ecbfa0a48008e91b6
    }

    public BaseballCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, int numCardsTotal, int numCardsInventory) {
        super(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInventory);
    }

    public double getValue() {
        return 0.0;
    }

}
