class Solution{
     public boolean checkInclusion(String s1, String s2)
    {
        int m=s1.length(),n=s2.length();
        if(m>n)
        {
            return false;
        }
        int[] map1=new int[26];
        int[] map2=new int[26];
        for(int i=0;i<s1.length();i++)
        {
             map1[s1.charAt(i)-'a']++;
             map2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(map1,map2)){
            return true;
        }
        for(int j=s1.length();j<s2.length();j++)
        {
           map2[s2.charAt(j)-'a']++;
           map2[s2.charAt(j-s1.length())-'a']--;
           if(Arrays.equals(map1,map2))
           {
            return true;
           }
        }
        return false;
    }
}