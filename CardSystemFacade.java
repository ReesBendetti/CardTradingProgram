import java.util.ArrayList;
import java.util.List;

public class CardSystemFacade {
    private static CardSystemFacade cardSystem;
    private User user;
    private Admin admin;

    private CardSystemFacade(){

    }

    public static CardSystemFacade getInstance(){
        if(cardSystem == null){
            cardSystem = new CardSystemFacade();
        }
        return cardSystem;
    }

    public boolean loginUser(String userName, String password) {
        user = AccountList.getInstance().loginUser(userName, password);

        if(user == null){
            return false;
        }
        return true;
    }

    public boolean loginAdmin(String userName, String password){
        admin = AccountList.getInstance().loginAdmin(userName, password);

        if(admin == null){
            return false;
        }
        return true;
    }

    public boolean signUp(String userName, String password, String email) {
        return AccountList.getInstance().addUser(userName, password, email);
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

    public ArrayList<Card> getMyCards(){
        return user.getCards();
    }

    public void logout(){
        AccountList.getInstance().save();
        CardInventory.getInstance().save();
    }
}
