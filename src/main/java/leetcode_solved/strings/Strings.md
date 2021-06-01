# Important Questions

### Text Justification

- Find the total number of characters that can be fit in one line
- Then find the number of spaces which need to be fit in between them
    - Is different if we're on the last line or only have one word
    - For any other line in the middle
- Use a pointer `i` to traverse all the words
- Store the total characters and the last word so far
```
while (lastWord < n) {
    if (totalChars + 1 + words[lastWord].length() > maxWidth) break;
    totalChars += 1 + words[lastWord].length();
    lastWord ++;
}
```
- The above snippet lets you determine how many words to process
- The number of gaps or spaces is `lastWord - i - 1`
- If we're on the last line or only have one word
    - Iterate from `i` to `lastWord` adding the word and a `" "`
    - Delete the last char after the loop
    - While the length of the `sb` is less than `maxWidth` add more `" "`
- Else (we're in the middle)
    - Calculate `numSpaces = (maxWidth - totalChars) / gapsInLine`
    - And `extra = (maxWidth - totalChars) % gapsInLine`
    - Loop from j = `i` to `lastWord - 1`
        - Add the word and `" "`
        - Add the `totalExtraSpaces = numSpaces + (j - i < extra ? 1 : 0);` spaces
    - Add the last word
- Add `sb.toString()` to result
- Make `i` as the index of `lastWord` 