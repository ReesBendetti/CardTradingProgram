import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardInventory {
    private ArrayList<Card> cards;
    private static CardInventory Inventory;

    private CardInventory() {
        cards = DataLoader.getCards();
    }

    public static CardInventory getInstance() {
        CardInventory inventory = new CardInventory();
        return inventory;
    }

    public boolean addCard(String playerFirstName, String playerLastName, String playerPosition, String sportsLeague, String teamName, int cardNumber, String playerTrivia, String rarityType, boolean isRookie, int numCardsTotal, int numCardsInventory) {
        
        if(sportsLeague.equals("baseball")){
            cards.add(new BaseballCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInventory));
            return true;
        } else if(sportsLeague.equals("football")){
            cards.add(new FootballCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInventory));
            return true;
        } else if(sportsLeague.equals("basketball")){
            cards.add(new BasketballCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInventory));
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

    public void removeCard(Card card) {

    }
    
    public List<Card> searchPlayer(String firstName, String lastName) {
        return cards;
    }

    public void save(){
        DataWriter.saveCards();
    }
}
