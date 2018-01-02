import java.io.*;
import java.util.*;

public class Solution {
    public String getText(String fileURL) throws IOException {
        FileReader fr = new FileReader(fileURL);
        BufferedReader br = new BufferedReader(fr);
        String line = "", text = "";
        while (line = br.readLine() != null) {
            text += currentLine;
        }
        br.close();
        return text;
    }

    public int shortestDistance(String fileURL, String word1, String word2) throws IOException {
        String text = getText(fileURL);
        String[] temp = text.split("\\s|.|,|;|!");
        List<String> words = new ArrayList<>();

        for (String word : temp) {
            word = word.trim();
            if (!word.isEmpty()) {
                words.add(word);
            }
        }
        int p1 = -1, p2 = -1;
        min = Integer.MAX_VALUE;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(word1))
                p1 = i;
            if (words.get(i).equals(word2))
                p2 = i;
            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }
        return min;
    }
}