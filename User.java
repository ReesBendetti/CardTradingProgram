import java.util.ArrayList;
import java.util.UUID;

public class User {
    private ArrayList<Card> cardCollection;
    private ArrayList<TradeProposal> proposedTrades;
    private ArrayList<TradeProposal> receivedTrades;
    private int coins;

    public User(UUID id, String username, String password, String email, int coins, ArrayList<Card> cardCollection) {
        
    }

    public String toString() {
        return "I am a user";
    }

    public ArrayList<TradeProposal> getProposedTrades() {
        return proposedTrades;
    }

    public ArrayList<TradeProposal> getReceivedTrades() {
        return receivedTrades;
    }

    public ArrayList<Card> getAllCards() {
        return cardCollection;
    }

    public void addCoins(int numCoins) {
        numCoins = coins;
    }

    public void removeCoins(int numCoins) {
        
    }
}
