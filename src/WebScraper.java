import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int wordCounter(String urlToString){

        int count = 0;

        boolean word = false;
        int endOfLine = urlToString.length() - 1;

        for (int i = 0; i < urlToString.length(); i++) {
            if (Character.isLetter(urlToString.charAt(i)) && i != endOfLine) {
                word = true;
            } else if (!Character.isLetter(urlToString.charAt(i)) && word) {
                count++;
                word = false;
            } else if (Character.isLetter(urlToString.charAt(i)) && i == endOfLine) {
                count++;
            }
        }
        return count;
    }


    public static void main (String[] unused){
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(wordCounter("http://erdani.com/tdpl/hamlet.txt"));
    }

}
