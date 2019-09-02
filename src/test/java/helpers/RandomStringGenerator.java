package helpers;

public class RandomStringGenerator {

    private static final String alphaNumericString = "ancdefghijklmnopqrstuvwxyz";

    //Method provide random string in lowercase letters
    public static String getRandomString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * alphaNumericString.length());
            builder.append(alphaNumericString.charAt(character));
        }
        return builder.toString();
    }
}
