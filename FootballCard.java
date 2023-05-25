import java.util.ArrayList;

public class FootballCard extends Card{
    public FootballCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String companyInfo)
     {
        super(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, null, cardNumber, playerTrivia, companyInfo, null);
    }
    public double getValue() {
        return 0.0;
    }
}
