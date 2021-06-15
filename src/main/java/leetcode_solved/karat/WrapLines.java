package leetcode_solved.karat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WrapLines {

    public List<String> wrapLines1(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            if (sb.length() == 0) sb.append(words[i ++]);
            else if (sb.length() + 1 + words[i].length() <= maxWidth) {
                sb.append("-").append(words[i ++]);
            } else {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() != 0) res.add(sb.toString());
        return res;
    }

    public List<String> wrapLines2(String[] words, int maxWidth) {
        List<String> ip = new ArrayList<>();
        for (String word : words) {
            String[] list = word.split(" ", -1);
            Collections.addAll(ip, list);
        }
        words = ip.toArray(new String[0]);
        List<String> res = new ArrayList<>();
        int i = 0, n = words.length;
        while (i < n) {
            int totalChars = words[i].length();
            int lastWord = i + 1;
            while (lastWord < n) {
                if (totalChars + 1 + words[lastWord].length() > maxWidth) break;
                totalChars += 1 + words[lastWord].length();
                lastWord++;
            }
            int gaps = lastWord - i - 1;
            StringBuilder sb = new StringBuilder();
            if (lastWord == n || gaps == 0) {
                for (int j = i; j < lastWord; j++) sb.append(words[j]).append("-");
                sb.deleteCharAt(sb.length() - 1);
                while (sb.length() < maxWidth) sb.append("-");
            } else {
                int spaces = (maxWidth - totalChars) / gaps;
                int extra = (maxWidth - totalChars) % gaps;
                for (int j = i; j < lastWord - 1; j++) {
                    sb.append(words[j]).append("-");
                    int addSpaces = j - i < extra ? 1 : 0;
                    for (int k = 0; k < spaces + addSpaces; k++) sb.append("-");
                }
                sb.append(words[lastWord - 1]);
                System.out.println(sb.toString());
            }

            res.add(sb.toString());
            i = lastWord;
        }
        return res;
    }

}
