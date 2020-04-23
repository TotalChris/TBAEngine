import java.util.Vector;

public class Location {
    private String roomTitle;
    private String roomDescription;
    //private Vector<Exit> exits;
    private Vector<Item> items;
    private Vector<GameEvent> events;

    public static class ItemNotFoundException extends Exception {
        Object reference;
        ItemNotFoundException(Object reference){
            super("Item was not found by reference " + reference + "in container.");
        }
        public Object getReference() {
            return reference;
        }
    }


    /**
     * Instantiates a new Location.
     */
    public Location() {
        this("", "");
    }


    /**
     * Instantiates a new Location.
     *
     * @param title the name of the room
     */
    public Location(String title) {
        this(title, "");
    }

    /**
     * Instantiates a new Location.
     *
     * @param title       the title of the room
     * @param description the description of the room
     */
    public Location(String title, String description) {
        // Assign title + description
        roomTitle = title;
        roomDescription = description;

        // Blank exits
        //exits = new Vector<>();
        items = new Vector<>();
        events = new Vector<>();
    }

    /**
     * Returns the string equivalent of the Location. Produces the same response as getTitle()
     *
     * @return The location's title.
     */
    public String toString() {
        return roomTitle;
    }
    /**
     * Gets the Location title.
     *
     * @return The Location title
     */
    public String getTitle() {
        return roomTitle;
    }
    /**
     * Sets the Location title.
     *
     * @param title The new Location title
     */
    public void setTitle(String title) {
        roomTitle = title;
    }

    /**
     * Gets the Location description.
     *
     * @return The Location description
     */
    public String getDescription() {
        return roomDescription;
    }

    /**
     * Sets the Location description.
     *
     * @param description The new Location description
     */
    public void setDescription(String description) {
        roomDescription = description;
    }

    /**
     * Add an event to this Location. It is good practice to specify a name for the event prior to adding it. This way, it is easy to find using getEvent() later on.
     *
     * @param event The event to add.
     */
    public void addEvent(GameEvent event) {
        events.add(event);
    }

    /**
     * Remove an event from this Location.
     *
     * @param event the event to remove
     * @return True if the event was removed from the list. False if the event was not found in the list.
     */
    public boolean removeEvent(GameEvent event) {
        return events.remove(event);
    }

    /**
     * Gets the event vector for this Location.
     *
     * @return The event vector for this Location
     */
    public Vector<GameEvent> getAllEvents() {
        return events;
    }

    /**
     * Get a specific event for the Location based on its name
     *
     * @param name The name string to look for
     * @return The event that has that name. If no event is found, returns null.
     */
    public GameEvent getEvent(String name){
        for (GameEvent e: events) {
            if(e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    /**
     * Add an item to this Location. It is good practice to specify a name for the item prior to adding it. This way, it is easy to find using getItem() later on.
     *
     * @param item The item to add.
     */
    public void placeItem(Item item) {
        items.add(item);
    }

    /**
     * Remove an item from this Location.
     *
     * @param item the item to remove
     * @return True if the item was removed from the list. False if the item was not found in the list.
     */
    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    /**
     * Gets the item vector for this Location.
     *
     * @return The item vector for this Location
     */
    public Vector<Item> getAllItems() {
        return items;
    }

    /**
     * Get a specific item for the Location based on its name
     *
     * @param name The name string to look for
     * @return The item that has that name. If no item is found, returns null.
     */
    public Item getItemByName(String name) throws ItemNotFoundException{
        for (Item i: items) {
            if(i.getName().equals(name)){
                return i;
            }
        }
        throw new ItemNotFoundException(name);
    }

    /**
     * Get all items string string.
     *
     * @return the string
     */
    public String getAllItemsString(){
        String response = "";
        Vector<Item> itemList = this.getAllItems();
        if(itemList.size() == 0){
            return "There is nothing in the room.";
        }
        for (Item item : itemList) {
            response += "There is a | " + item.getName() + " | in the room.\n";
            //if(item instanceof Container){
            //    response += ((Container)item).getAllItemsString(item.getName());
            //}
        }
        return response;
    }
}
