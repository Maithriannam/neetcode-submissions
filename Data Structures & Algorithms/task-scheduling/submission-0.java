class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c:tasks)
        {
            freq[c-'A']++;
        }
        Arrays.sort(freq);
        int max=freq[25];
        int count=0;
        for(int f:freq)
        {
            if(f==max)
            {
                count++;
            }
        }
        int part1=(max-1)*(n+1)+count;
        int part2=tasks.length;
        return Math.max(part1,part2);
    }
}