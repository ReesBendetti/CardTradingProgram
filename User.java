import java.util.ArrayList;
import java.util.UUID;

public class User extends Account {
    private ArrayList<Card> cardCollection;
    private ArrayList<TradeProposal> proposedTrades ;
    private ArrayList<TradeProposal> receivedTrades;
    private int coins;
    private static final int COIN_COUNT = 25;

    public User(UUID id, String username, String password, String email, int coins, ArrayList<Card> cardCollection) {
        super(id, username, password, email, false);
        this.coins = coins;
        this.cardCollection = cardCollection;
        proposedTrades = new ArrayList<TradeProposal>();
        receivedTrades = new ArrayList<TradeProposal>();
    }

    public User(String username, String password, String email) {
        super(username, password, email, false);
        coins = COIN_COUNT;
        cardCollection = new ArrayList<Card>();
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

    public void addProposedTrade(TradeProposal proposal){
        proposedTrades.add(proposal);
    }

    public void addReceivedTrades(TradeProposal proposal){
        receivedTrades.add(proposal);
    }

    public ArrayList<Card> getCards() {
        return cardCollection;
    }

    public void addCoins(int numCoins) {
        coins += numCoins;
    }

    public void removeCoins(int numCoins) {
        coins -= numCoins;
    }
    public int getCoins() {
        return coins;
    }
}
