import java.util.ArrayList;
import java.util.UUID;

public class Admin extends Account {
    private ArrayList<Card> cardCollection;
    private ArrayList<TradeProposal> proposedTrades;
    private ArrayList<TradeProposal> receivedTrades;
    private int coins;

    public Admin(UUID id, String username, String password, String email) {
        super(id, username, password, email);
    }

    public String toString() {
        return "I am an admin";
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
        coins += numCoins;
    }

    public void removeCoins(int numCoins) {
        coins -= numCoins;
    }
}
