class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0,maxlen=0;
        Set<Character> str=new HashSet<>();
        for(int right=0;right<s.length();right++)
        {
          while(str.contains(s.charAt(right)))
          {
            str.remove(s.charAt(left));
            left++;
          }
          str.add(s.charAt(right));
          maxlen=Math.max(maxlen,right-left+1);
        }
        
        return maxlen;
    }
}
