import java.util.ArrayList;
import java.util.UUID;
public class BaseballCard extends Card {
    public BaseballCard(UUID id, String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, int numCardsTotal, int numCardsInventory) {
        super(id, playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInventory);    
    }

    public BaseballCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, int numCardsTotal) {
        super(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal);
    }

    public double getValue() {
        return 0.0;
    }

}
