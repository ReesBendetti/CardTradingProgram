import java.util.ArrayList;
public class BaseballCard extends Card{
    public BaseballCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String companyInfo) {
        super(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, playerStats, cardNumber, playerTrivia, companyInfo, null, null, cardNumber, cardNumber);
    }
    public double getValue() {
        return 0.0;
    }

}
