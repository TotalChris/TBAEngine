import java.util.Vector;

public class Container extends Item {
    private Vector<Item> contents;
    private int capacity;
    private int size;

    public Container(){
        this(null, 64);
    }

    public Container(String name){
        this(name, 64);
    }

    public Container(String name, int capacity){
        super(name);
        contents = new Vector<>();
        this.capacity = capacity;
        this.size = 0;
    }

    public boolean contains(Item item){
        return contents.contains(item);
    }

    public void addItem(Item item) {
        int weight = ( item instanceof Container ? ((Container) item).capacity : 1);
        if(this.size + weight < capacity){
            contents.add(item);
            this.size =+ weight;
        } else {
            //container full, fail!
        }
    }

    public void removeItem(Item item)  {
        if(this.contains(item)){
            contents.remove(item);
            int weight = ( item instanceof Container ? ((Container) item).capacity : 1);
            this.size =- weight;
        } else {
            //item not in container, fail!
        }
    }

    public int getSize(){
        return this.size;
    }

    /**
     * Gets the capacity of the container.
     * @return the capacity of this container
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * Set the integer capacity of the container. Will only decrease the capacity if there are currently less items than the target capacity of the container.
     * @param capacity the target capacity of the container.
     */
    public void setCapacity(int capacity){
        if(capacity >= size) {
            this.capacity = capacity;
        }
    }

    /**
     * Checks if the container is empty.
     * @return true if the container is empty, and false otherwise.
     */
    public boolean isEmpty(){
        return size == 0;
    }


    /**
     * Checks if the container is full.
     * @return true if the container is filled to capacity with items, and false otherwise.
     */
    public boolean isFull() {
        return contents.size() == capacity;
    }


}
