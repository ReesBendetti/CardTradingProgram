package card_system;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardInventory {
    private ArrayList<Card> cards;
    private static CardInventory inventory;

    private CardInventory() {
        cards = DataLoader.getCards();
    }

    public static CardInventory getInstance() {
        if(inventory == null){
            inventory = new CardInventory();
        }
        return inventory;
    }

    public boolean addCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, int cardNumber, String playerTrivia, String rarityType, boolean isRookie, int numCardsTotal, int numCardsInventory) {
        
        if(sportsLeague.equalsIgnoreCase("baseball")){
            cards.add(new BaseballCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal));
            return true;
        } else if(sportsLeague.equalsIgnoreCase("football")){
            cards.add(new FootballCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal));
            return true;
        } else if(sportsLeague.equalsIgnoreCase("basketball")){
            cards.add(new BasketballCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal));
            return true;
        }
        return false;
    }

    public ArrayList<Card> getCards(){
        return cards;
    }

    public Card getCardById(UUID id){
        for(Card card : cards){
            if(card.getId().equals(id)){
                return card;
            }
        }

        return null;
    }
    //-----------------------------------------------------------------
    public Card cardSearch(Card c) {
        Card card = new Card(null, null, null, null, null, null, 0, null, null, null, 0, 0);
        for(int i = 0; i<cards.size(); i++)
            if(cards.get(i).equals(c))
            card = c;
            return card;
    }

    public void removeCard(Card card) {
        
    }
    
    public List<Card> searchPlayer(String firstName, String lastName) {
        ArrayList<Card> foundCards = new ArrayList<Card>();

        for(Card card: cards){
            if(card.getFirstName().equalsIgnoreCase(firstName) &&
            card.getLastName().equalsIgnoreCase(lastName)){
                foundCards.add(card);
            }
        }
        return foundCards;
    }

    public Card getCard(String firstName, String lastName, String userName){
        for(Card card : cards){
            if(card.getFirstName().equalsIgnoreCase(firstName) &&
            card.getLastName().equalsIgnoreCase(lastName)){
                for(User user : card.getOwners()){
                    if(user.getUserName().equalsIgnoreCase(userName)){
                        return card;
                    }
                }
            }
        }
        return null;
    }

    public void save(){
        DataWriter.saveCards();
    }
}
