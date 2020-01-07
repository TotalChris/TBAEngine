import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEventTest {
    private GameEvent testEvent;
    private GameEvent testEventNullName;
    private GameEvent testEventNullReturn;
    private GameEvent testEventNullAction;

    @Before
    public void init() throws Exception {
        testEvent = new GameEvent("Event1", () -> {
            return "Return1";
        });
        testEventNullName = new GameEvent( null, () -> {
          return "Return2";
        });
        testEventNullAction = new GameEvent("Event3", null);
        testEventNullReturn = new GameEvent("Event4", () -> {
            return null;
        });
    }

    @Test
    public void doActionTest() {
        assertEquals("Return1", testEvent.doAction());
    }

    @Test
    public void setActionTest() {
        testEvent.setAction(() -> {
            return "ReturnModified";
        });
        assertEquals("ReturnModified", testEvent.doAction());
    }

    @Test
    public void getActionTest() {
        Action a = testEvent.getAction();
        assertNotNull(a);
        assertNotNull(a.reaction());
    }

    @Test
    public void namingTest() {
        assertEquals(testEvent.getName(), "Event1");
        testEvent.setName("EventModified");
        assertEquals(testEvent.getName(), "EventModified");
    }

    @Test
    public void nullNamingTest() {
        assertNull(testEventNullName.getName());
    }

    @Test
    public void nullActionTest() {
        assertNull(testEventNullAction.doAction());
    }

    @Test
    public void nullReturnTest() {
        assertNull(testEventNullReturn.doAction());
    }
}