package card_system;
import java.util.ArrayList;
import java.util.List;

public class CardSystemFacade {
    private static CardSystemFacade cardSystem;
    private Account account;

    private CardSystemFacade(){
        CardInventory.getInstance();
        AccountList.getInstance();
        DataLoader.loadProposedTrades();
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

    public ArrayList<TradeProposal> getProposedTrades() {
        if (!account.isAdmin()) {
            return ((User)account).getProposedTrades();
        }

        return null;
    }

    public ArrayList<TradeProposal> getReceivedTrades() {
        if (!account.isAdmin()) {
            return ((User)account).getReceivedTrades();
        }

        return null;
    }

    public int compareCards(Card card1, Card card2) {
        return CardComparator.compareCard(card1, card2);
    }

    public int compareCardSet(ArrayList<Card> cardSet1, ArrayList<Card> cardSet2) {
        return CardComparator.compareCardSet(cardSet1, cardSet2);
    }

    public ArrayList<Card> getAllCards() {
        return CardInventory.getInstance().getCards();
    }

    public List<Card> searchPlayer(String firstName, String lastName) {
        return CardInventory.getInstance().searchPlayer(firstName, lastName);
    }

    public boolean addCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, ArrayList<String> playerStats, int cardNumber, String playerTrivia, String rarityType, boolean isRookie) {
       return CardInventory.getInstance().addCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, cardNumber, cardNumber);
    }

    public void removeCard(Card card) {
        CardInventory.getInstance().removeCard(card);
    }

    public void buyCardPack(Card card) {
        if (!account.isAdmin()) {
            User user = (User) account;
            user.getCards();
        }
    }

    public int getCurrentCoinCount() {
        if (!account.isAdmin()) {
            User user = (User) account;
            return user.getCoins();
        }
        return 0;
    }

    public ArrayList<Card> getMyCards(){
        if (!account.isAdmin()) {
            User user = (User) account;
            return user.getCards();
        }
        return new ArrayList<>();
    }

    public void logout(){
        AccountList.getInstance().save();
        CardInventory.getInstance().save();
        DataWriter.saveProposals();
    }
}
