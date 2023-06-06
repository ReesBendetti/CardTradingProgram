package testing;

import card_system.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CardInventoryTest {
    @Test
    public void testSearchPlayer() {
        List<Card> cards = CardInventory.getInstance().searchPlayer("Michael", "Jordan");
        assertEquals(1, cards.size());
    }
}
