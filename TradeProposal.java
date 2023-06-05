import java.util.ArrayList;

import javax.sound.sampled.ReverbType;

public class TradeProposal {
    private User sender;
    private User receiver;
    private ArrayList<Card> senderCards;
    private ArrayList<Card> receiverCards;
    private static TradeProposal proposal;
    private int status = 0;

    public TradeProposal(User sender, User receiver, ArrayList<Card> senderCards, ArrayList<Card> receiverCards, int status){
        this.sender = sender;
        this.receiver = receiver;
        this.senderCards = senderCards;
        this.receiverCards = receiverCards;
        this.status = status;
    }

    public static TradeProposal getInstance(User sender, User receiver, ArrayList<Card> senderCards, ArrayList<Card> receiverCards, int status) {
        if (proposal == null) {
            proposal = new TradeProposal(sender, receiver, senderCards, receiverCards, status);
        }
        return proposal;
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
