import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CardSystemUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Card Trading System";
    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
	private String[] loginMenuOptions = {"Login", "Signup","Quit"};
    private String[] mainMenuOptions = {"View Your Cards", "Quit"};
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
        
        while(true){
            int menuChoice = getMenuChoice("Main Menu", mainMenuOptions);

            if(menuChoice == mainMenuOptions.length - 1){
                System.out.println("Good bye and have a nice day.");
                cardSystem.logout();
                return;
            }

            if(menuChoice == 0){
                displayCards(cardSystem.getMyCards());
            }
        }
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

            if (cardSystem.loginUser(userName, password)) {
                System.out.println("You've successfully logged in as a User.");
                timeout();
                clear();
                return true;
            } else if (cardSystem.loginAdmin(userName, password)) {
                System.out.println("You've successfully logged in as an Admin.");
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

    private boolean signup(){
        return true;
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

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void timeout() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (Exception e) {
            System.out.println("Timmer error");
        }
    }

    public static void main(String[] args){
        (new CardSystemUI()).run();
    }
}
