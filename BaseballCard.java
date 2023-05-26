import java.util.ArrayList;
import java.util.UUID;
public class BaseballCard extends Card{
    public BaseballCard(UUID id, String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, ArrayList<User> users, int numCardsTotal, int numCardsInventory) {
        super(id, playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, rarityType, isRookie, users, numCardsTotal, numCardsInventory);
        
    }

    public BaseballCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, int numCardsTotal, int numCardsInventory) {
        super(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInventory);
    }

    public double getValue() {
        return 0.0;
    }

}
