import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
	
	
	public static void saveCards() {
		CardInventory inventory = CardInventory.getInstance();
		ArrayList<Card> cards = inventory.getCards();
		JSONArray jsonCards = new JSONArray();
		//creating all the json objects
		for(int i=0; i< cards.size(); i++) {
			jsonCards.add(getCardJSON(cards.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(CARDS_FILE_NAME)) {
 
            file.write(jsonCards.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static JSONObject getCardJSON(Card card) {
		JSONObject cardDetails = new JSONObject();
      cardDetails.put(CARD_ID, card.getId().toString());
		cardDetails.put(CARD_PLAYER_FIRST_NAME, card.getFirstName());
		cardDetails.put(CARD_PLAYER_LAST_NAME, card.getLastName());
		cardDetails.put(CARD_PLAYER_POSITION, card.getPlayerPosition());
		cardDetails.put(CARD_SPORTS_LEAGUE, card.getSportLeague());
      cardDetails.put(CARD_TEAM_NAME, card.getTeamName());
      cardDetails.put(CARD_NUMBER, card.getCardNumber());
      cardDetails.put(CARD_PLAYER_TRIVIA, card.getPlayerTrivia());
      cardDetails.put(CARD_RARITY_TYPE, card.getRarityType());
      cardDetails.put(CARD_IS_ROOKIE, card.isRookie());
      cardDetails.put(CARD_NUMBER_TOTAL_CARDS, card.getNumberCardsTotal());
      cardDetails.put(CARD_TOTAL_CARD_INVENTORY, card.getNumberCardsInventory());
        return cardDetails;
	}
   
   public static void saveAccounts() {
		//AccountList list = AccountList.getInstance();
		//ArrayList<User> users = list.getUser(null);
		ArrayList<User> users = DataLoader.getUsers();
		JSONArray jsonUsers = new JSONArray();
		
		//creating all the json objects
		for(int i=0; i< users.size(); i++) {
			jsonUsers.add(getUserJSON(users.get(i)));
		}
		
		//Write JSON file
        try (FileWriter file = new FileWriter(USERS_FILE_NAME)) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
   public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();
      userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_USERNAME, user.getUserName());
      userDetails.put(USER_PASSWORD, user.getPassword());
		userDetails.put(USER_EMAIL, user.getEmail());
		userDetails.put(USER_COINS, user.getCoins());
		userDetails.put(USER_CARDS, user.getCards());
      return userDetails;
   }

	public static void main(String[] args){
		saveCards();
      saveAccounts();
      //CardInventory inventory = CardInventory.getInstance();
	}
}