public class GameEvent {
    private Action a;
    public String name;
    GameEvent(){
        this("", null);
    }
    GameEvent(String name){
        this(name, null);
    }
    GameEvent(Action a){
        this("", a);
    }
    GameEvent(String name, Action a){
        this.name = name;
        this.a = a;
    }
    public String doAction(){
        return a.reaction();
    }
    public void setAction(Action a){
        this.a = a;
    }
    public Action getAction() { return this.a; }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
