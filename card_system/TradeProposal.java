package card_system;
import java.util.ArrayList;

public class TradeProposal {
    private User sender;
    private User receiver;
    private ArrayList<Card> senderCards;
    private ArrayList<Card> receiverCards;
    private int status = 0;

    public TradeProposal(User sender, User receiver, ArrayList<Card> senderCards, ArrayList<Card> receiverCards, int status){
        this.sender = sender;
        this.receiver = receiver;
        this.senderCards = senderCards;
        this.receiverCards = receiverCards;
        this.status = status;
        sender.addProposedTrade(this);
        receiver.addProposedTrade(this);
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
        //ToDO: add and remove cards appropriately
        //update cards for sender and receiver. remove and add for each. then update cards.
        for(int i =0;i<receiverCards.size();i++) {
            sender.addCard(receiverCards.get(i));
            receiver.removeCard(receiverCards.get(i));
        }
        for(int i =0;i<senderCards.size();i++) {
            receiver.addCard(senderCards.get(i));
            sender.removeCard(senderCards.get(i));
        }

    }

    public void declineOffer(){
        status = -1; 
    }
}
