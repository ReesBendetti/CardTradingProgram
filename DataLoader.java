import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;

public class DataLoader extends DataConstants {
    public static ArrayList<Card> getCards(){
        ArrayList<Card> cards = new ArrayList<Card>();

        try {
			FileReader reader = new FileReader(CARDS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray cardsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < cardsJSON.size(); i++) {
                /*private ArrayList<String> playerStats;
    private int cardNumber;
    private String playerTrivia;
    private String rarityType;
    private Boolean isRookie;
    private ArrayList<User> users;
    private int numCardsTotal;
    private int numCardsInInventory;*/
				JSONObject cardJSON = (JSONObject)cardsJSON.get(i);
                UUID cardID = UUID.fromString((String)cardJSON.get(CARD_ID));
				String playerFirstName = (String)cardJSON.get(CARD_PLAYER_FIRST_NAME);
                String playerLastName = (String)cardJSON.get(CARD_PLAYER_LAST_NAME);
                String playerPosition = (String)cardJSON.get(CARD_PLAYER_POSITION);
                String playerTeamName = (String)cardJSON.get(CARD_TEAM_NAME);
                int cardNumber = (int)cardJSON.get(CARD_NUMBER);
                String playerTrivia = (String)cardJSON.get(CARD_PLAYER_TRIVIA);
                String rarityType = (String)cardJSON.get(CARD_RARITY_TYPE);
                Boolean isRookie = (Boolean)cardJSON.get(CARD_RARITY_TYPE);
                int numCardsTotal = (int)cardJSON.get(CARD_NUMBER_TOTAL_CARDS);
                int numCardsInInventory = (int)cardJSON.get(CARD_TOTAL_CARD_INVENTORY);


				System.out.println("Test: " + cardID + " " + playerFirstName);
				
				cards.add(new Card(cardID, playerFirstName, playerLastName, playerPosition, playerTeamName, rarityType, cardsJSON, cardNumber, playerTrivia,
                                    rarityType, isRookie, cardsJSON, numCardsTotal, numCardsInInventory));
			}
			
			return cards;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            return cards;
        }
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
