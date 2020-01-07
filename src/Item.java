public class Item{
    private String name;

    public Item(){
        this.name = "";
    }
    public Item(String name){
        this.name = name;
    }
    public String toString(){ return this.getName(); }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
