public class Util {
    public static void main(String[] args) {

    }
    public static boolean isVowelWord(String word){
        return "AEIOUaeiou".indexOf(word.toUpperCase().charAt(0)) != -1;
    }
}
