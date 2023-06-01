import java.util.ArrayList;

import javax.sound.sampled.ReverbType;

public class TradeProposal {
    private User sender;
    private User receiver;
    private ArrayList<Card> senderCards;
    private ArrayList<Card> receiverCards;
    private int status = 0;

    public TradeProposal(User sender, User receiver, ArrayList<Card> senderCards, ArrayList<Card> receiverCards){
        this.sender = sender;
        this.receiver = receiver;
        this.senderCards = senderCards;
        this.receiverCards = receiverCards;
    }
    public User getSender() {
        return sender;
    }
    public User getReceiver() {
        return receiver;
    }
    public int getStatus() {
        return status;
    }
    public ArrayList<Card> getSenderCards() {
        return senderCards;
    }
    public ArrayList<Card> getReceiverCards() {
        return receiverCards;
    }

    public void acceptOffer(){
        status = 1; 
    }

    public void declineOffer(){
        status = -1;
    }
}
