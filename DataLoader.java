import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {
    public static ArrayList<Card> getCards() {
        ArrayList<Card> cards = new ArrayList<Card>();

        try {
            FileReader reader = new FileReader(CARDS_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray cardsJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < cardsJSON.size(); i++) {
                JSONObject cardJSON = (JSONObject) cardsJSON.get(i);
                UUID cardID = UUID.fromString((String) cardJSON.get("id"));
                String playerFirstName = (String) cardJSON.get("player-first-name");
                String playerLastName = (String) cardJSON.get("player-last-name");
                String playerPosition = (String) cardJSON.get("player-position");
                String sportsLeague = (String) cardJSON.get("sports-league");
                String teamName = (String) cardJSON.get("team-name");
                int cardNumber = Integer.parseInt(String.valueOf(cardJSON.get("card-number")));
                String playerTrivia = (String) cardJSON.get("player-trivia");
                String rarityType = (String) cardJSON.get("rarity type");
                boolean isRookie = (boolean) cardJSON.get("is-rookie");
                int numberTotalCards = Integer.parseInt(String.valueOf(cardJSON.get("number-total-cards")));
                int totalCardsInventory = Integer.parseInt(String.valueOf(cardJSON.get("total-cards-inventory")));

                // I think I still need to add cardID but not sure how to implement it into the cards.json
                Card card = new Card(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, cardNumber, playerTrivia, rarityType, isRookie, numberTotalCards, totalCardsInventory);
                cards.add(card);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cards;
    }

    public static ArrayList<Account> getAccounts(){
        ArrayList<Account> accounts = new ArrayList<Account>();
 
        return accounts;
    }
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();
        return users;
    }

    public static void main(String[] args){
        DataLoader.getCards();
    }
}
