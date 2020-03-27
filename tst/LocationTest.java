import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {
    private Location testLocationDefault;
    private Location testLocationEmptyTitle;
    private Location testLocationEmptyDescription;
    private Location testLocationEmptyTitleAndDescription;
    @Before
    public void init() throws Exception {
        testLocationDefault = new Location("Empty Room", "The room is completely featureless, with no doors, windows, or distinguishable characteristics.");
        testLocationEmptyTitle = new Location("", "The room does not exist, because it has no name.");
        testLocationEmptyDescription = new Location("Mystery Room");
        testLocationEmptyTitleAndDescription = new Location();
    }

    @Test
    public void testToString() {
        assertEquals(testLocationDefault.toString(), "Empty Room");
        assertEquals(testLocationEmptyTitle.toString(), "");
        assertEquals(testLocationEmptyDescription.toString(), "Mystery Room");
        assertEquals(testLocationEmptyTitleAndDescription.toString(), "");
    }

    @Test
    public void testGetAndSetTitle() {
        assertEquals(testLocationDefault.getTitle(), "Empty Room");
        testLocationDefault.setTitle("Just Another Empty Room");
        assertEquals(testLocationDefault.getTitle(), "Just Another Empty Room");
    }

    @Test
    public void testGetAndSetDescription() {
        assertEquals(testLocationDefault.getDescription(), "The room is completely featureless, with no doors, windows, or distinguishable characteristics.");
        assertEquals(testLocationEmptyTitle.getDescription(), "The room does not exist, because it has no name.");
        assertEquals(testLocationEmptyDescription.getDescription(), "");
        assertEquals(testLocationEmptyTitleAndDescription.getDescription(), "");
        testLocationDefault.setDescription("The room is empty");
        assertEquals(testLocationDefault.getDescription(), "The room is empty");
    }

    @Test
    public void locationEventTest() {
        //Tests an average scenario where the user adds, runs, and then removes a working event from the location.
        assertEquals(testLocationDefault.getAllEvents().size(), 0);                                           //check
        testLocationDefault.addEvent(new GameEvent("Test Event", () -> {                                      //add
            return "Test event success!";
        }));
        assertEquals(testLocationDefault.getAllEvents().size(), 1);                                           //check
        assertEquals(testLocationDefault.getEvent("Test Event").doAction(), "Test event success!");     //run
        testLocationDefault.removeEvent(testLocationDefault.getEvent("Test Event"));                          //remove
        assertEquals(testLocationDefault.getAllEvents().size(), 0);                                           //check
    }

    @Test
    public void placeItem() {
    }

    @Test
    public void removeItem() {
    }

    @Test
    public void getAllItem() {
    }

    @Test
    public void getItemByName() {
    }

    @Test
    public void getAllItemsString() {
    }
}