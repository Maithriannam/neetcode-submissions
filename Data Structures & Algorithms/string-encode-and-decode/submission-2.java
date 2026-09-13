

class Solution {

    public String encode(List<String> strs) {

        String result = "";

        for (String str : strs) {
            result = result + str.length() + "#" + str;
        }

        return result;
    }

    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;

        while (i < s.length()) {

            int j = i;

            // Find '#'
            while (s.charAt(j) != '#') {
                j++;
            }

            // Get length
            int len = Integer.parseInt(s.substring(i, j));

            // Move after '#'
            j++;

            // Get the actual string
            String word = s.substring(j, j + len);

            result.add(word);

            // Move i to the next encoded string
            i = j + len;
        }

        return result;
    }
}