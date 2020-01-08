import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item testItem;
    private Item testItemNullName;

    @Before
    public void init() throws Exception {
        testItem = new Item("Item Name");
        testItemNullName = new Item(null);
    }

    @Test
    public void testToString() {
        assertEquals(testItem.toString(), "Item Name");
        assertNull(testItemNullName.toString());
    }

    @Test
    public void getAndSetNameTest() {
        testItem.setName("Modified Item Name");
        assertEquals(testItem.getName(), "Modified Item Name");

        testItemNullName.setName("Modified Item Name 2");
        assertEquals(testItemNullName.getName(), "Modified Item Name 2");

        testItemNullName.setName(null);
        assertNull(testItemNullName.getName());
    }
}