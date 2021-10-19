public class DemoGame {
    public static void main(String[] args) {
        Container box = new Container("Box", 10);
        box.addItem(new Item("Apple"));
        box.addItem(new Item("Banana"));
        box.addItem(new Item("Orange"));
        box.addItem(new Item("Kiwi"));
        System.out.println("The size of the box is " + box.getSize() + " items.");
        for (Item i : box) {
            System.out.println("There is a" + (Util.isVowelWord(i.getName())?"n":"") + " |" + i.getName() + "| in the " + box.getName() + ".");

        }
    }

    public void init(){

    }


}

