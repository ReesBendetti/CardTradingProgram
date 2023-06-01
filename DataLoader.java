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
			JSONArray cardsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < cardsJSON.size(); i++) {
				JSONObject cardJSON = (JSONObject)cardsJSON.get(i);
                UUID cardID = UUID.fromString((String)cardJSON.get(CARD_ID));
				String playerFirstName = (String)cardJSON.get(CARD_PLAYER_FIRST_NAME);
                String playerLastName = (String)cardJSON.get(CARD_PLAYER_LAST_NAME);
                String playerPosition = (String)cardJSON.get(CARD_PLAYER_POSITION);
                String sportsLeague = (String)cardJSON.get(CARD_SPORTS_LEAGUE);
                String playerTeamName = (String)cardJSON.get(CARD_TEAM_NAME);
                int cardNumber = ((Long)cardJSON.get(CARD_NUMBER)).intValue();
                String playerTrivia = (String)cardJSON.get(CARD_PLAYER_TRIVIA);
                String rarityType = (String)cardJSON.get(CARD_RARITY_TYPE);
                Boolean isRookie = (boolean)cardJSON.get(CARD_IS_ROOKIE);
                int numCardsTotal = ((Long)cardJSON.get(CARD_NUMBER_TOTAL_CARDS)).intValue();
                int numCardsInInventory = ((Long)cardJSON.get(CARD_TOTAL_CARD_INVENTORY)).intValue();
				
                if (sportsLeague.equalsIgnoreCase("baseball")) {
				    cards.add(new BaseballCard(cardID, playerFirstName, playerLastName, playerPosition, sportsLeague, playerTeamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInInventory));
                } else if (sportsLeague.equalsIgnoreCase("basketball")) {
                    cards.add(new BasketballCard(cardID, playerFirstName, playerLastName, playerPosition, sportsLeague, playerTeamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInInventory));
                } else if (sportsLeague.equalsIgnoreCase("football")) {
                    cards.add(new FootballCard(cardID, playerFirstName, playerLastName, playerPosition, sportsLeague, playerTeamName, cardNumber, playerTrivia, rarityType, isRookie, numCardsTotal, numCardsInInventory));
                }
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
        try {
            FileReader reader = new FileReader(USERS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                UUID id = UUID.fromString((String)userJSON.get(USER_ID));
                String username = (String)userJSON.get(USER_USERNAME);
                String password = (String)userJSON.get(USER_PASSWORD);
                String email = (String)userJSON.get(USER_EMAIL);
                int coins = ((Long)userJSON.get(USER_COINS)).intValue();
                JSONArray cardsJSON = (JSONArray)userJSON.get(USER_CARDS);

                ArrayList<Card> cards = new ArrayList<Card>();
                for (int j = 0; j < cardsJSON.size(); j++) {
                    UUID cardID = UUID.fromString((String)cardsJSON.get(j));
                    Card card = CardInventory.getInstance().getCardById(cardID);
                    cards.add(card);
                }
                User user = new User(id, username, password, email, coins, cards);

                for(Card card : cards){
                    card.addUser(user);
                }
                users.add(user);
            }
            return users;
        }
        catch(Exception e) {
            e.printStackTrace();
        } finally {
            return users;
        }
    }

    public static ArrayList<Admin> getAdmin() {
        ArrayList<Admin> admins = new ArrayList<Admin>();
        try {
            FileReader reader = new FileReader(ADMIN_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray adminsJSON = (JSONArray)new JSONParser().parse(reader);

            for (int i = 0; i < adminsJSON.size(); i++) {
                JSONObject adminJSON = (JSONObject)adminsJSON.get(i);
                UUID id = UUID.fromString((String)adminJSON.get(ADMIN_ID));
                String username = (String)adminJSON.get(ADMIN_USERNAME);
                String password = (String)adminJSON.get(ADMIN_PASSWORD);
                String email = (String)adminJSON.get(ADMIN_EMAIL);
                
                admins.add(new Admin(id, username, password, email));
            }
            return admins;
        }
        catch(Exception e) {
            e.printStackTrace();
        } finally {
            return admins;
        }
    }

    public static void loadProposedTrades() {
        try {
            FileReader reader = new FileReader(PROPOSALS_FILE_NAME);
			JSONParser parser = new JSONParser();
			JSONArray proposalsJSON = (JSONArray)new JSONParser().parse(reader);
            for (int i = 0; i < proposalsJSON.size(); i++) {
                JSONObject proposalJSON = (JSONObject)proposalsJSON.get(i);
                User sender = getUserByUUID((String)proposalJSON.get(PROPOSAL_SENDER));
                User receiver = getUserByUUID((String)proposalJSON.get(PROPOSAL_RECEIVER));
                ArrayList<Card> senderCards = getCards((JSONArray)proposalJSON.get(PROPOSAL_SENDER_CARDS));
                ArrayList<Card> receiverCards = getCards((JSONArray)proposalJSON.get(PROPOSAL_RECEIVER_CARDS));
                int status = ((Long)proposalJSON.get(PROPOSAL_STATUS)).intValue();

                TradeProposal proposal = new TradeProposal(sender, receiver, senderCards, receiverCards, status);
                sender.addProposedTrade(proposal);
                receiver.addReceivedTrades(proposal);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        } finally {
        }
    }

    private static ArrayList<Card> getCards(JSONArray jsonCards){
        ArrayList<Card> cards = new ArrayList<Card>();

        for (int i = 0; i < jsonCards.size(); i++) {
            UUID cardId = UUID.fromString((String)jsonCards.get(i));
            Card card = CardInventory.getInstance().getCardById(cardId);
            cards.add(card);
        }

        return cards;
    }

    private static User getUserByUUID(String id){
        UUID uuid = UUID.fromString(id);
        return AccountList.getInstance().getUserById(uuid);
    }

    public static void main(String[] args) {
    }
}
