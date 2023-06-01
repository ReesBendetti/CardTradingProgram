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
		AccountList list = AccountList.getInstance();
		ArrayList<User> users = list.getUsers();
		//ArrayList<User> users = DataLoader.getUsers();
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

		ArrayList<Card> usersCards = user.getCards();
		//create a json array
		//loop through user cards
		//add each item to the json array
		//then add the json array to user details
      JSONArray jsonUsercards = new JSONArray();
      for(int i = 0; i<usersCards.size(); i++) {
         jsonUsercards.add(usersCards.get(i).getId().toString());
      }
		userDetails.put(USER_CARDS, jsonUsercards);
      return userDetails;
   }
   public static void saveAdmins() {
		ArrayList<Admin> admins = DataLoader.getAdmin();
		JSONArray jsonAdmins = new JSONArray();
		
		for(int i=0; i< admins.size(); i++) {
			jsonAdmins.add(getAdminJSON(admins.get(i)));
		}
		
        try (FileWriter file = new FileWriter(ADMIN_FILE_NAME)) {
 
            file.write(jsonAdmins.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
   public static JSONObject getAdminJSON(Admin admin) {
		JSONObject adminDetails = new JSONObject();
      adminDetails.put(ADMIN_ID, admin.getId().toString());
		adminDetails.put(ADMIN_USERNAME, admin.getUserName());
      adminDetails.put(ADMIN_PASSWORD, admin.getPassword());
		adminDetails.put(ADMIN_EMAIL, admin.getEmail());
      return adminDetails;
   }
   public static void saveProposals() {
		ArrayList<TradeProposal> proposals = DataLoader.getProposedTrade();
		JSONArray jsonProposals = new JSONArray();
		
		for(int i=0; i< proposals.size(); i++) {
			jsonProposals.add(getProposalJSON(proposals.get(i)));
		}
		
        try (FileWriter file = new FileWriter(PROPOSALS_FILE_NAME)) {
 
            file.write(jsonProposals.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
   public static JSONObject getProposalJSON(TradeProposal proposal) {
		JSONObject proposalDetails = new JSONObject();
      proposalDetails.put(PROPOSAL_SENDER, proposal.getSender());
		proposalDetails.put(PROPOSAL_RECEIVER, proposal.getReceiver());
      ArrayList<Card> senderCards = proposal.getSenderCards();
      JSONArray jsonSendercards = new JSONArray();
      for(int i = 0;i<senderCards.size(); i++) {
         jsonSendercards.add(senderCards.get(i));
      }
      proposalDetails.put(PROPOSAL_SENDER_CARD, jsonSendercards);
      ArrayList<Card> receiverCards = proposal.getReceiverCards();
      JSONArray jsonReceivercards = new JSONArray();
      for(int i = 0;i<receiverCards.size(); i++) {
         jsonReceivercards.add(receiverCards.get(i));
      }
		proposalDetails.put(PROPOSAL_RECEIVER_CARDS, jsonReceivercards);
      proposalDetails.put(PROPOSAL_STATUS, proposal.getStatus());
      return proposalDetails;
   }

	public static void main(String[] args){
      saveCards();
      saveAccounts();
      saveAdmins();
      saveProposals();
      //CardInventory inventory = CardInventory.getInstance();
	}
}