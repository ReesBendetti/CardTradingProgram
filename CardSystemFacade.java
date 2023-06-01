import java.util.ArrayList;
import java.util.List;

public class CardSystemFacade {
    private static CardSystemFacade cardSystem;
    private Account account;

    private CardSystemFacade(){

    }

    public ArrayList<User> getUsers() {
        return AccountList.getInstance().getUsers();
     }

    public static CardSystemFacade getInstance(){
        if(cardSystem == null){
            cardSystem = new CardSystemFacade();
        }
        return cardSystem;
    }

    public Account getCurrentAccount(){
        return account;
    }

    public boolean login(String userName, String password) {
        account = AccountList.getInstance().login(userName, password);

        if(account == null){
            return false;
        }
        return true;
    }

    public boolean signUp(String userName, String password, String email) {
        account =  AccountList.getInstance().addUser(userName, password, email);

        if(account == null){
            return false;
        }
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
       CardInventory cardInventory = new CardInventory();
       return cardInventory.addCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, cardNumber, cardNumber);
    }

    public void removeCard(Card card) {
        
    }

    public void purchaseCards(Card card) {
        
    }

    public int getCurrentCoinCount() {
        return 0;
    }

    public ArrayList<Card> getMyCards(){
        return ((User)account).getCards();
    }

    public void logout(){
        AccountList.getInstance().save();
        CardInventory.getInstance().save();
    }
}
