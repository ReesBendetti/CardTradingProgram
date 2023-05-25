import java.util.ArrayList;

public class TradeProposal {
    private User sender;
    private User receiver;
    private ArrayList<Card> senderCards;
    private ArrayList<Card> receiverCards;
    private int status = 0;

    public TradeProposal(User sender, User receiver, ArrayList<Card> senderCardd, ArrayList<Card> receiverCards){
        this.sender = sender;
        this.receiver = receiver;
        this.senderCards = senderCards;
        this.receiverCards = receiverCards;
    }

    public void acceptOffer(){
        status = 1; 
    }

    public void declineOffer(){
        status = -1;
    }
}
