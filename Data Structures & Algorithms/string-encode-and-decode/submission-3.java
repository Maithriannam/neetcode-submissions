
class Solution {

    public String encode(List<String> strs) {
        String result="";
        for(String str:strs)
        {
            result=result+str.length()+'#'+str;
        }
        return result;

    }

    public List<String> decode(String str) {

         ArrayList<String> l=new ArrayList<>();
               int i=0;
               while(i<str.length())
               {
                  int j=i;
                  while(str.charAt(j)!='#')
                  {
                    j++;
                  }
                  int len=Integer.parseInt(str.substring(i,j));
                  j++;
                  String p=str.substring(j,j+len);
                  l.add(p);
                  i=j+len;



               }
         return l;
    }
}
