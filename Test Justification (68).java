class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        ArrayList<String> text = new ArrayList<String>();

        for (int i = 0; i < words.length; i++){
            int len = 0; final int start = i;
            while (i < words.length && (len += words[i++].length() + 1) < maxWidth + 1);
            if (len > maxWidth + 1)
                len -= words[--i].length() + 1;
            i--; len--;
            final int space; 
            int remain;
            if (i > start){
                space = (maxWidth - len) / (i - start);
                remain = (maxWidth - len) % (i - start);
            } else {
                space = maxWidth;
                remain = 0;
            }

            StringBuilder str = new StringBuilder(maxWidth);
            for (int j = start; j < i; j++){
                str.append(words[j]); str.append(' ');
                if (i < words.length - 1){
                    for (int k = 0; k < space; k++){
                        str.append(' ');
                    }
                    if (remain-- > 0) str.append(' ');
                }
            }
            str.append(words[i]);
            for (int j = str.length(); j < maxWidth; j++)
                str.append(' ');
            text.add(str.toString());
        }
        return text;
    }
}
