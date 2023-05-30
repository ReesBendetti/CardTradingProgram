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
		/*userDetails.put(USER_ID, user.getId().toString());
		userDetails.put(USER_USER_NAME, user.getUserName());
		userDetails.put(USER_FIRST_NAME, user.getFirstName());
		userDetails.put(USER_LAST_NAME, user.getLastName());
		userDetails.put(USER_AGE, user.getAge());
		userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());*/
        
        return cardDetails;
	}
}