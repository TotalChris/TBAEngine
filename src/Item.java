/**
 * Items represent an object that can be carried or used in the engine. Subtypes like Container represent extended functionality.
 */
public class Item{
    private String name;
    private String description;

    /**
     * Instantiates a new item. The item name is set to an empty value.
     */
    public Item(){
        this.name = "";
    }

    /**
     * Instantiates a new item.
     *
     * @param name the name to use for this item.
     */
    public Item(String name){
        this.name = name;
    }
    public String toString(){ return this.getName(); }

    /**
     * Set the name for this item.
     *
     * @param name the name to set for this item
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get the name of this item.
     *
     * @return the name of this item
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set the description for this item.
     *
     * @param desc the name to set for this item
     */
    public void setDescription(String desc){
        this.description = desc;
    }

    /**
     * Get the description of this item.
     *
     * @return the description of this item
     */
    public String getDescription(){
        return this.description;
    }
}