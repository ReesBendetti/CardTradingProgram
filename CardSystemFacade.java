import java.util.ArrayList;
import java.util.List;

public class CardSystemFacade {
    private User user;

    public boolean login(String userName, String password) {
        return true;
    }

    public boolean signUp(String userName, String password, String email) {
        return true;
    }

    public void signOut() {

    }

    public ArrayList<TradeProposal> getProposedTrades() {
        return null;
    }

    public ArrayList<TradeProposal> getReceivedTrades() {
        return null;
    }

    public int compareCards(Card card1, Card card2) {
        return 0;
    }

    public int compareCardSet(List<Card> cardSet1, List<Card> cardSet2) {
        return 0;
    }

    public ArrayList<Card> getAllCards() {
        return null;
    }

    public ArrayList<Card> searchAllUserCards() {
        return null;
    }

    public List<Card> searchPlayer(String firstName, String lastName) {
        return null;
    }

    public boolean addCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, boolean isRookie) {
        return true;
    }

    public void removeCard(Card card) {
        
    }

    public void purchaseCards(Card card) {
        
    }

    public int getCurrentCoinCount() {
        return 0;
    }
}
