package testing;

import card_system.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardInventoryTest {
    
    // @BeforeEach
    // public void setup() {
    //     // Reset the card inventory before each test
    //     CardInventory.getInstance().getCards().clear();
    // }
    
    @Test
    public void testSearchPlayer() {
        // Add a card for Michael Jordan to the inventory
        CardInventory.getInstance().addCard("Michael", "Jordan", "Shooting Guard", "Basketball", "Bulls", 23, "Michael Jordan trivia", null, true, 1, 1);
        
        List<Card> cards = CardInventory.getInstance().searchPlayer("Michael", "Jordan");
        assertEquals(1, cards.size());
    }

    @Test
    public void testSearchPlayerInvalid() {
        // No card added for "Fake Lies"
        List<Card> cards = CardInventory.getInstance().searchPlayer("Fake", "Fake");
        assertEquals(0, cards.size());
    }
    
    @Test
    public void testAddCardBaseball() {
        boolean added = CardInventory.getInstance().addCard("Hulk", "Hogan", "Outfielder", "Baseball", "Yankees", 3, "Hulk Hogan trivia", "exclusive", true, 1, 1);
        assertTrue(added);
        
        List<Card> cards = CardInventory.getInstance().getCards();
        assertEquals(15, cards.size());
        
        Card addedCard = cards.get(14);
        assertEquals("Hulk", addedCard.getFirstName());
        assertEquals("Hogan", addedCard.getLastName());
        assertEquals("Outfielder", addedCard.getPlayerPosition());
        assertEquals("Baseball", addedCard.getSportLeague());
        assertEquals("Yankees", addedCard.getTeamName());
        assertEquals(3, addedCard.getCardNumber());
        assertEquals("Hulk Hogan trivia", addedCard.getPlayerTrivia());
        assertEquals("exclusive", addedCard.getRarityType());
        assertTrue(addedCard.isRookie());
        assertEquals(1, addedCard.getNumberCardsTotal());
        assertEquals(1, addedCard.getNumberCardsInventory());
    }
    
    //not sure this accomplishes anything useful
    @Test
    public void testAddCardInvalidSportsLeague() {
        boolean added = CardInventory.getInstance().addCard("John", "Doe", "Forward", "Soccer", "Reds", 7, "John Doe trivia", "common", true, 1, 1);
        assertFalse(added);
        
        // Verify that no card is added to the inventory
        List<Card> cards = CardInventory.getInstance().getCards();
        assertEquals(14, cards.size());
    }
    
    @Test
    public void testGetCardById() {
        // Add a card to the inventory
        CardInventory.getInstance().addCard("Mark", "Hamill", "Small Forward", "Basketball", "Lakers", 6, "Mark Hamill trivia", null, true, 1, 1);
        
        // Get the card by ID
        List<Card> cards = CardInventory.getInstance().getCards();
        Card card = cards.get(14);
        Card retrievedCard = CardInventory.getInstance().getCardById(card.getId());
        
        // Verify that the retrieved card is the same as the original card
        assertNotNull(retrievedCard);
        assertEquals(card, retrievedCard);
    }
    
    @Test
    public void testGetCardByInvalidId() {
        // Add a card to the inventory
        CardInventory.getInstance().addCard("Kobe", "Bryant", "Shooting Guard", "Basketball", "Lakers", 8, "Kobe Bryant trivia", null, true, 1, 1);
        
        // Get a card with an invalid ID
        Card retrievedCard = CardInventory.getInstance().getCardById(UUID.randomUUID());
        
        // Verify that no card is retrieved
        assertNull(retrievedCard);
    }
    
    @Test
    public void testCardSearch() {
        // Add a card to the inventory
        CardInventory.getInstance().addCard("Tom", "Brady", "Quarterback", "Football", "Patriots", 12, "Tom Brady trivia", "common", false, 1, 1);
        
        // Create a card object for searching
        Card searchCard = new FootballCard("Tom", "Brady", "Quarterback", "Football", "Patriots", 12, "Tom Brady trivia", "common", false, 1);
        
        // Perform the card search
        Card foundCard = CardInventory.getInstance().cardSearch(searchCard);
        
        // Verify that the found card matches the search card
        assertNotNull(foundCard);
        assertEquals(searchCard, foundCard);
    }
    
    @Test
    public void testRemoveCard() {
        // Add a card to the inventory
        CardInventory.getInstance().addCard("Magic", "Johnson", "Point Guard", "Basketball", "Lakers", 32, "Magic Johnson trivia", null, true, 1, 1);
        
        // Get the card from the inventory
        List<Card> cards = CardInventory.getInstance().getCards();
        Card card = cards.get(0);
        
        // Remove the card from the inventory
        CardInventory.getInstance().removeCard(card);
        
        // Verify that the card is no longer in the inventory
        List<Card> updatedCards = CardInventory.getInstance().getCards();
        assertEquals(0, updatedCards.size());
    }
}
