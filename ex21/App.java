package t_11_holdingYourObjects.ex21;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args)
    {
        final File file = new File("D:\\words.txt");
        Map<String, Integer> words = new HashMap<>();
        getWords(file, words);

        System.out.println(words);

        List<String> wordList = new ArrayList<String>(words.keySet());

        Collections.sort(wordList, String.CASE_INSENSITIVE_ORDER);

        System.out.println(wordList);
    }

    private static void getWords(File file, Map<String, Integer> map)
    {
        int counter = 0;
        try (Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(file))))
        {
            scanner.useDelimiter("\\W+");
            while (scanner.hasNext())
            {
                map.put(scanner.next(), ++counter);
            }
        }
        catch (FileNotFoundException e)
        {
            System.err.println("File " + file.getName() + " not found.");
        }
    }

}
