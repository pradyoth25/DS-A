package leetcode_solved.strings;

import java.util.ArrayList;
import java.util.List;

public class WrapLines {

    /**
     * Pt.1 Connecting words with '-' as blank spaces, no exceeds maxLength
     * Input: String[] words, int maxLength.
     *
     * Output: List lines.
     *
     *   e.g. ["1p3acres", "is", "a", "good", "place", "to", "communicate"], 12
     *   OP => {"1p3acres-is", "a-good-place", "for", "communicate"}
     */
    public List<String> wrapLines1(String[] words, int maxLength) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < words.length) {
            // Assume that for the first word, its length does not exceed maxLength
            if (sb.length() == 0) sb.append(words[i ++]);
            else  if (sb.length() + 1 + words[i].length() <= maxLength) {
                sb.append("-").append(words[i ++]);
            } else {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (sb.length() != 0) res.add(sb.toString());
        return res;
    }

    /**
     * Decide how many words could put in the same line
     * Modify the spaces between words: 1) Not the last line 2) The last line OR One word in line
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int n = words.length;
        int i = 0; // index of first word being processed
        while (i < n) {
            int totalChars = words[i].length();
            int last = i + 1; // index of last word being processed

            while (last < n) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last ++;
            }
            int gaps = last - i - 1;
            StringBuilder sb = new StringBuilder();
            if (last == n || gaps == 0) {
                // This is for case two
                // Last line or just one word in the line
                for (int j = i; j < last; j ++) {
                    sb.append(words[j]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                // Fill in the spaces until maxWidth is reached
                while (sb.length() < maxWidth) sb.append(" ");
            } else {
                // Middle lines
                int spaces = (maxWidth - totalChars) / gaps;
                int rest = (maxWidth - totalChars) % gaps;
                for (int j = i; j < last - 1; j ++) {
                    sb.append(words[j]).append(" ");
                    int kLoop = spaces + (j - i < rest ? 1 : 0);
                    for (int k = 0; k < kLoop; k ++) {
                        sb.append(" ");
                    }
                }
                sb.append(words[last - 1]);
            }
            res.add(sb.toString());
            i = last;
        }
        return res;
    }

}
