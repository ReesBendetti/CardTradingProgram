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
    
    @Test
    public void testSearchPlayer() {
        CardInventory.getInstance().addCard("Michael", "Jordan", "Shooting Guard", "Basketball", "Bulls", 23, "Michael Jordan trivia", null, true, 1, 1);
        
        List<Card> cards = CardInventory.getInstance().searchPlayer("Michael", "Jordan");
        assertEquals(1, cards.size());
    }

    @Test
    public void testSearchPlayerInvalid() {
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
    
    @Test
    public void testGetCardById() {
        CardInventory.getInstance().addCard("Mark", "Hamill", "Small Forward", "Basketball", "Lakers", 6, "Mark Hamill trivia", null, true, 1, 1);
        
        List<Card> cards = CardInventory.getInstance().getCards();
        Card card = cards.get(14);
        Card retrievedCard = CardInventory.getInstance().getCardById(card.getId());
        
        assertNotNull(retrievedCard);
        assertEquals(card, retrievedCard);
    }
    
    @Test
    public void testGetCardByInvalidId() {
        CardInventory.getInstance().addCard("Kobe", "Bryant", "Shooting Guard", "Basketball", "Lakers", 8, "Kobe Bryant trivia", null, true, 1, 1);
        
        Card retrievedCard = CardInventory.getInstance().getCardById(UUID.randomUUID());
        
        assertNull(retrievedCard);
    }
    
    @Test
    public void testGetCards() {
        CardInventory.getInstance().addCard("", "James", "Small Forward", "Basketball", "Lakers", 6, "LeBron James trivia", null, true, 1, 1);
        CardInventory.getInstance().addCard("Steph", "Curry", "Point Guard", "Basketball", "Warriors", 30, "Steph Curry trivia", null, true, 1, 1);
        CardInventory.getInstance().addCard("Aaron", "Rodgers", "Quarterback", "Football", "Packers", 12, "Aaron Rodgers trivia", null, false, 1, 1);
        
        List<Card> cards = CardInventory.getInstance().getCards();
        
        assertEquals(17, cards.size());
    }

    @Test
    public void testCardSearch() {
        CardInventory.getInstance().addCard("Tom", "Brady", "Quarterback", "Football", "Patriots", 12, "Tom Brady trivia", "common", false, 1, 1);
        
        Card searchCard = new FootballCard("Tom", "Brady", "Quarterback", "Football", "Patriots", 12, "Tom Brady trivia", "common", false, 1);
        
        Card foundCard = CardInventory.getInstance().cardSearch(searchCard);
        
        assertNotNull(foundCard);
        assertEquals(searchCard, foundCard);
    }
    
    @Test
    public void testRemoveCard() {
        CardInventory.getInstance().addCard("Magic", "Johnson", "Point Guard", "Basketball", "Lakers", 32, "Magic Johnson trivia", null, true, 1, 1);
        
        List<Card> cards = CardInventory.getInstance().getCards();
        Card card = cards.get(0);
        
        CardInventory.getInstance().removeCard(card);
        
        List<Card> updatedCards = CardInventory.getInstance().getCards();
        assertEquals(0, updatedCards.size());
    }

    @Test
    public void testRemoveCardInvalid() {
        CardInventory.getInstance().addCard("Magic", "Johnson", "Point Guard", "Basketball", "Lakers", 32, "Magic Johnson trivia", null, true, 1, 1);
        
        Card invalidCard = new BasketballCard("Larry", "Bird", "Forward", "Basketball", "Celtics", 33, "Larry Bird trivia", null, true, 1);

        CardInventory.getInstance().removeCard(invalidCard);
        
        List<Card> cards = CardInventory.getInstance().getCards();
        assertEquals(15, cards.size());
    }
}
