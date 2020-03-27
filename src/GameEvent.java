/**
 * The GameEvent class helps define an easily callable and executable event in the engine.
 * GameEvents are defined with string names, and lambdas which must return string or null output.
 * The lambda, called an Action, can be redefined on-the-fly.
 * Any code can be defined in the Action body to determine the final string.
 * See constructor-specific JavaDocs for more specific instructions.
 */
public class GameEvent {
    private Action a;
    private String name;

    public interface Action {
        public String action();
    }

    /**
     * Instantiates a new GameEvent. The name is blank, and the action is null. Calling doAction() will return a null value.
     */
    GameEvent(){
        this("", null);
    }

    /**
     * Instantiates a new GameEvent. The name is set to the provided value, and the action is null. Calling doAction() will return a null value.
     *
     * @param name the name of the GameEvent
     */
    GameEvent(String name){
        this(name, null);
    }

    /**
     * Instantiates a new GameEvent. The name is blank, and the action is set to the provided value. Calling doAction() will return the final string response.
     *
     * @param a The lambda that outlines the action steps. Must return either a string response or null.
     */
    GameEvent(Action a){
        this("", a);
    }

    /**
     * Instantiates a new GameEvent. Both the name and the action are set to their provided values. Calling doAction() will return the final string response.
     *
     * @param name the name of the GameEvent
     * @param a    The lambda that outlines the action steps. Must return either a string response or null.
     */
    GameEvent(String name, Action a){
        this.name = name;
        this.a = a;
    }

    /**
     * Run the action for this GameEvent.
     *
     * @return The string response calculated by the defined action. Returns null if the action has yet to be set.
     */
    public String doAction(){
        if(a != null){
            return a.action();
        } else {
            return null;
        }
    }

    /**
     * Set the action for this GameEvent.
     *
     * @param a The lambda that outlines the action steps. Must return either a string response or null.
     */
    public void setAction(Action a){
        this.a = a;
    }

    /**
     * Gets the action object for this GameEvent. Running GameEvent.getAction().reaction() will do the same thing as GameEvent.doAction().
     *
     * @return The action object, containing one public method, reaction(). This is the lambda code for the GameEvent.
     */
    public Action getAction() { return this.a; }

    /**
     * Set the name of this GameEvent.
     *
     * @param name The new name for the event.
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Get the name of this GameEvent.
     *
     * @return The current name of the event.
     */
    public String getName(){
        return this.name;
    }
}
