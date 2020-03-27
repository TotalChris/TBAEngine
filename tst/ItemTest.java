import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    private Item testItemDefault;
    private Item testItemNullName;

    @Before
    public void init() throws Exception {
        testItemDefault = new Item("Item Name");
        testItemNullName = new Item(null);
    }

    @Test
    public void testToString() {
        assertEquals(testItemDefault.toString(), "Item Name");
        assertNull(testItemNullName.toString());
    }

    @Test
    public void getAndSetNameTest() {
        testItemDefault.setName("Modified Item Name");
        assertEquals(testItemDefault.getName(), "Modified Item Name");

        testItemNullName.setName("Modified Item Name 2");
        assertEquals(testItemNullName.getName(), "Modified Item Name 2");

        testItemNullName.setName(null);
        assertNull(testItemNullName.getName());
    }
}