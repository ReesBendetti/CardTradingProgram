import java.io.FileReader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.ArrayList;

public class DataLoader {
    public static ArrayList<Card> getCards(){
        ArrayList<Card> cards = new ArrayList<Card>();

        try {
			FileReader reader = new FileReader(CARDS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray cardsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < cardsJSON.size(); i++) {
				JSONObject cardJSON = (JSONObject)cardsJSON.get(i);
				String playerFirstName = (String)cardJSON.get(CARD_PLAYER_FIRST_NAME);
				System.out.println(playerFirstName);
				
				//cards.add(new Card(...));
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

    public static void main(String[] args){
        System.out.println("hi");
    }
}
