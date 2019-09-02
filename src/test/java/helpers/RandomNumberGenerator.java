package helpers;

public class RandomNumberGenerator {

    private static int max = 50;
    private static int min = 1;

    //Method provide random number
    public static int getrandomNumber() {
        int randomeNumber = (int) (Math.random() * ((max - min) + 1)) + min;
        return randomeNumber;
    }
}
