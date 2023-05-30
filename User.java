import java.util.ArrayList;

public class User {
    private ArrayList<Card> cardCollection;
    private ArrayList<TradeProposal> proposedTrades;
    private ArrayList<TradeProposal> receivedTrades;
    private int coins;

    public User(String username, String password, String email) {
        
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
