import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameEventTest {
    private GameEvent testEventDefault;
    private GameEvent testEventNullName;
    private GameEvent testEventNullReturn;
    private GameEvent testEventNullAction;

    @Before
    public void init() throws Exception {
        testEventDefault = new GameEvent("Event1", () -> {
            return "Return1";
        });
        testEventNullName = new GameEvent(() -> {
          return "Return2";
        });
        testEventNullAction = new GameEvent("Event3");
        testEventNullReturn = new GameEvent("Event4", () -> {
            return null;
        });
    }

    @Test
    public void doActionTest() {
        assertEquals("Return1", testEventDefault.doAction());
    }

    @Test
    public void setActionTest() {
        testEventDefault.setAction(() -> {
            return "ReturnModified";
        });
        assertEquals("ReturnModified", testEventDefault.doAction());
    }

    /*
    Test the normal functionality of retrieving an action.
    Here, we get the action from from the standard testEvent, and assert that both itself and its reaction property are not null.
     */
    @Test
    public void getActionTest() {
        GameEvent.Action a = testEventDefault.getAction();
        assertNotNull(a);
        assertNotNull(a.action());
    }


    @Test
    public void namingTest() {
        assertEquals(testEventDefault.getName(), "Event1");
        testEventDefault.setName("EventModified");
        assertEquals(testEventDefault.getName(), "EventModified");
    }

    @Test
    public void emptyNamingTest() {
        assertEquals(testEventNullName.getName(), "");
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