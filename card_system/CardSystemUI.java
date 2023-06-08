package card_system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class CardSystemUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Card Trading System";
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
	private String[] loginMenuOptions = {"Login", "Signup","Quit"};
    private String[] mainMenuOptions = {"View Your Cards", "Purchase New Cards", "Trading", "Search Player", "Quit"};
    private String[] mainMenuAdminOptions = {"View a User's Cards", "Add Cards", "Quit"};
    private String[] sportsLeagues = {"Baseball", "Basketball", "Football"};
    private String[] trading = {"Propose New Trade", "View Pending Trades", "Exit Trading"};
    private String[] purchasing = {"Small Card Pack", "Large Card Pack"};
    private String[] choice =  {"Accept", "Reject"};
	private Scanner scanner;
    private CardSystemFacade cardSystem;

    public CardSystemUI(){
        clear();
        scanner = new Scanner(System.in);
        cardSystem = CardSystemFacade.getInstance();
    }
    
    public void run(){
        System.out.println(WELCOME_MESSAGE);

        if(!loginOrSignUp()) return;
        
        if(cardSystem.getCurrentAccount().isAdmin()){
            runAdmin();
        } else {
            runUser();
        }

        cardSystem.logout();
    }

    private void runUser(){
        while(true){
            int menuChoice = getMenuChoice("User Main Menu", mainMenuOptions);

            if (menuChoice == mainMenuOptions.length - 1){
                System.out.println("Good bye user! Have a nice day.");
                return;
            }

            if (menuChoice == 0) {
                displayCards(cardSystem.getMyCards());
            } else if (menuChoice == 1) {
                buyCards();
            } else if (menuChoice == 2) {
                trading();
            } else if (menuChoice == 3) {
                searching();
            }
        }
    }

    private void runAdmin(){
        while(true){
            int menuChoice = getMenuChoice("Admin Main Menu", mainMenuAdminOptions);

            if (menuChoice == mainMenuAdminOptions.length - 1){
                System.out.println("Good bye administrator! Have a nice day.");
                return;
            }

            if (menuChoice == 0) {
                ArrayList<User> users = CardSystemFacade.getInstance().getUsers();

                for (int i = 0; i < users.size(); i++) {
                    System.out.println((i + 1) + " " + users.get(i).getUserName());
                }

                timeout();

            } else if (menuChoice == 1) {
                //add a card
                addCard();
            } 
        }
    }

    private void searching(){
        System.out.println("Searching for a player....");

        String playersFirstName = getString("Enter Players First Name");
        String playersLastName = getString("Enter Players Last Name");

        List<Card> cards = cardSystem.searchPlayer(playersFirstName, playersLastName);

        for(Card card : cards){
            ArrayList<User> owners = card.getOwners();
            System.out.println(card );
            
            System.out.println("Owned by: ");
            for(User user : owners){
                System.out.println("- " + user);
            }
        }
    }

    private void trading() {
        while (true) {
            int menuChoice = getMenuChoice("Trading Menu", trading);
            if (menuChoice == 0) {
                proposeTrade();
            } else if (menuChoice == 1) {
                viewPendingTrades();
            } else {
                return;
            }
        }
    }

    

    private void proposeTrade() {
        System.out.println("******** Propose a New Trade ********");

        String myPlayerFirstName = getString("Enter the first name of the sports player from your own card collection:");
        String myPlayerLastName = getString("Enter the last name of the sports player from your own card collection:");
        String otherUsername = getString("Enter the username of the user you want to trade with:");
        String otherPlayerFirstName = getString("Enter the First name of the sports player card you want to receive in the trade:");
        String otherPlayerLastName = getString("Enter the Last name of the sports player card you want to receive in the trade:");

        Card card1 = cardSystem.getCard(myPlayerFirstName, myPlayerLastName, cardSystem.getCurrentAccount().getUserName());
        Card card2 = cardSystem.getCard(otherPlayerFirstName, otherPlayerLastName, otherUsername);
        User otherUser = cardSystem.getUser(otherUsername);

        if(card1 != null && card2 != null && otherUser != null){
            cardSystem.proposeTrade(otherUser, card1, card2);
        }

        System.out.println("Trade proposal sent!");
        timeout();
        clear();
    }

    private void viewPendingTrades() {
        ArrayList<TradeProposal> proposedTrades = cardSystem.getProposedTrades();

        System.out.println("\nProposed Trades:");
        displayTrades(proposedTrades);
        
        ArrayList<TradeProposal> receivedTrades = cardSystem.getReceivedTrades();

        System.out.println("\nReceived Trades:");
        displayTrades(receivedTrades);
        
/* 
        int tradeIndex = getInt("Enter the index of the trade you want to accept or reject (0 to cancel):");

        if (tradeIndex > 0 && tradeIndex <= pendingTrades.size()) {
            int decision = getMenuChoice("Accept or Reject the Trade?", choice);

            if (decision == 0) {
                acceptTrade(tradeIndex - 1);
            } else if (decision == 1) {
                rejectTrade(tradeIndex - 1);
            }
        }
        clear();*/
    }

    private void displayTrades(ArrayList<TradeProposal> proposals){
        if (proposals.isEmpty()) {
            System.out.println("No trades.");
            return;
        }

        for (int i = 0; i < proposals.size(); i++) {
            TradeProposal trade = proposals.get(i);

            System.out.println("Trade " + (i + 1) + ":");

            System.out.println("My Players: ");
            ArrayList<Card> senderCards = trade.getSenderCards();
            for (int j = 0; j < senderCards.size(); j++) {
                System.out.println(senderCards.get(j));
            }

            System.out.println("Other User's Players: ");
            ArrayList<Card> receiverCards = trade.getReceiverCards();
            for (int j = 0; j < receiverCards.size(); j++) {
                System.out.println(receiverCards.get(j));
            }

            System.out.println("Status: " + trade.getStatus());
        }

        int choiceIndex = getMenuChoice("Accept or Reject a Trade", choice);

        if (choiceIndex == 0) {
            int tradeIndex = getInt("Enter the trade number to accept: ") - 1;
            acceptTrade(tradeIndex);
        } else if (choiceIndex == 1) {
            int tradeIndex = getInt("Enter the trade number to reject: ") - 1;
            rejectTrade(tradeIndex);
        }
    }

    private void acceptTrade(int tradeIndex) {
        ArrayList<TradeProposal> proposedTrades = cardSystem.getProposedTrades();
    
        if (tradeIndex >= 0 && tradeIndex < proposedTrades.size()) {
            TradeProposal trade = proposedTrades.get(tradeIndex);
            trade.acceptOffer();
            System.out.println("Trade accepted!");
        } else {
            System.out.println("Invalid trade index.");
        }
    }

    private void rejectTrade(int tradeIndex) {
        ArrayList<TradeProposal> proposedTrades = cardSystem.getProposedTrades();
    
        if (tradeIndex >= 0 && tradeIndex < proposedTrades.size()) {
            TradeProposal trade = proposedTrades.get(tradeIndex);
            trade.declineOffer();
            System.out.println("Trade rejected!");
        } else {
            System.out.println("Invalid trade index.");
        }
    }

    private void buyCards() {
        int menuChoice = getMenuChoice("Which Type of Cards?", sportsLeagues);
        int league;

        if (menuChoice == 0) {
            league = 0; //Baseball
        } else if (menuChoice == 1) {
            league = 1; //Basketball
        } else if (menuChoice == 2) {
            league = 2; //Football
        } else {
            return; // User canceled
        }

        menuChoice = getMenuChoice("Which Sized Card Pack?", purchasing);

        if (menuChoice == 0) {
            buyCardPack(league, "Small");
        } else if (menuChoice == 1) {
            buyCardPack(league, "Large");
        } else {
            return; // User canceled
        }
    }

    private void buyCardPack(int league, String packSize) {
        ArrayList<Card> newCards = cardSystem.buyCardPack(league, packSize);

        if (newCards.isEmpty()) {
            System.out.println("Failed to buy the card pack.");
        } else {
            System.out.println("You bought a " + packSize + " Card Pack!");

            System.out.println("New Cards:");
            displayCards(newCards);
        }

        timeout();
        clear();
    }

    private void addCard(){
        System.out.println("Create Card Information.");
        String playerFirstName = getString("Player First Name");
        String playerLastName = getString("Player Last Name");
        String playerPosition = getString("Player Position");
        String teamName = getString("Team Name");
        String sportsLeague = getSportsLeague();
        int cardNumber = getInt("Card Number");
        String playerTrivia = getString("Player Trivia");
        String rarityType = getString("Rarity Type");
        boolean isRookie = getBoolean(getString("Is a rookie"));
        int numCardsTotal = getInt("Total Number of Cards");
        cardSystem.addCard(playerFirstName, playerLastName, playerPosition, sportsLeague, teamName, null, cardNumber, playerTrivia, rarityType, isRookie);
    }

    private static boolean getBoolean(String data){
        return data.equalsIgnoreCase("true");
    }

    private String getSportsLeague(){
        int choice = getMenuChoice("Pick a sports League", sportsLeagues);
        return sportsLeagues[choice];
    }

    private void displayCards(ArrayList<Card> cards){
        clear();
        System.out.println("Cards:");
        for(Card card : cards){
            System.out.println(card);
        }
    }

    private boolean loginOrSignUp(){
        int lsChoice = getMenuChoice("Login or Signup", loginMenuOptions);

        if(lsChoice == loginMenuOptions.length - 1){
            System.out.println("Good bye and have a nice day.");
            return false;
        } 
        clear();

        if(lsChoice == 0){
            return login();
        } else {
            return signup();
        }
    }

    private boolean login(){
        while(true){
            System.out.println("Enter Login credentials.");
            String userName = getString("username");
            String password = getString("password");

            if (cardSystem.login(userName, password)) {
                System.out.println("You've successfully logged in.");
                timeout();
                clear();
                return true;
            }

            System.out.println("Sorry, invalid login");

            if(!tryAgain()){
                return false;
            }
               
        }
    }

    private boolean signup() {
        while(true){
            System.out.println("Create Login credentials.");
            String userName = getString("username");
            String password = getString("password");
            String email = getString("email");

            if (cardSystem.signUp(userName, password, email)) {
                System.out.println("You've made your account and are now successfully logged in as a User.");
                timeout();
                clear();
                return true;
            }

            System.out.println("Sorry, invalid login");

            if(!tryAgain()){
                return false;
            }
               
        }
    }

    private boolean tryAgain(){
        while(true){
            System.out.println("Would you like to try again?");
            System.out.println("1. Try Again");
            System.out.println("2. Quit");
            int response = getUserCommand(2);

            if(response == -1){
                System.out.println("Not a valid response.");
                continue;
            }

            if(response == 0){
                return true;
            }
            return false;
        }
    }

    /**
     * Determines if the user wants to login, signup or quit
     * @return 0 if they want to login, 1 if they want to signup, and 2 if they want to quit 
     */
    private int getMenuChoice(String title, String[] options){
        while(true){
            displayMenu(title, options);

            int userCommand = getUserCommand(options.length);
			
			if(userCommand == -1) {
				System.out.println("Not a valid command");
				continue;
			}

            return userCommand;
        }
    }

    private void displayMenu(String title, String[] options){
        System.out.println("\n************ " + title + " *************");
		for(int i=0; i< options.length; i++) {
			System.out.println((i+1) + ". " + options[i]);
		}
    }

    /**
     * Gets the number the user entered, between 1 and the numCommands
     * @param numCommands The number of options they have to enter
     * @return -1 if they entered an invalid number, and the number otherwise
     */
	private int getUserCommand(int numCommands) {
		System.out.print("What would you like to do?: ");
		
		String input = scanner.nextLine();
		int command = Integer.parseInt(input) - 1;
		
		if(command >= 0 && command <= numCommands -1) return command;
		
		return -1;
	}

    private String getString(String prompt) {
		while(true) {
            System.out.print(prompt + ": ");
			String content = scanner.nextLine().trim().toLowerCase();
			if(!content.contentEquals("")) return content;	
			System.out.println("Sorry, your data was blank");
		}
	}

    private int getInt(String prompt) {
        System.out.print(prompt + ": ");
        int num = scanner.nextInt();
        scanner.nextLine();
        return num;
	}

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void timeout() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (Exception e) {
            System.out.println("Timer error");
        }
    }

    public static void main(String[] args){
        (new CardSystemUI()).run();
    }
}
