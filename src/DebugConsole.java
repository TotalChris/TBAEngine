import java.util.Scanner;


public class DebugConsole {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inString = "";
        while (input.hasNext() && !inString.equals("QUIT")) {
                inString = input.nextLine().toUpperCase();
                System.out.println(inString);
                translateCmd(inString);
        }
        input.close();
    }

    private static void translateCmd(String inString) {
        //case statement here
    }
}
