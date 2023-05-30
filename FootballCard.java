import java.util.ArrayList;
import java.util.UUID;

public class FootballCard extends Card {
    public FootballCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String companyInfo)
     {
        super(id, playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, companyInfo, null, null, cardNumber, cardNumber);
     }
    public FootballCard(UUID id, String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, ArrayList<User> users, int numCardsTotal, int numCardsInventory) {
        super(id, playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, rarityType, isRookie, users, numCardsTotal, numCardsInventory);
    }

    public FootballCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, Boolean isRookie, int numCardsTotal, int numCardsInventory) {
        super(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInventory);
    }

    public double getValue() {
        return 0.0;
    }
}
