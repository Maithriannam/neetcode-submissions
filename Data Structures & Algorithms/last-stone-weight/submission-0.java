class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones==null||stones.length==0)
        {
            return 0;
        }
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int s:stones)
        {
            minHeap.offer(s);
        }
        while(minHeap.size()>1)
        {
            int a=minHeap.poll();
            int b=minHeap.poll();
            if(a!=b)
            {
                int rem=a-b;
                minHeap.offer(rem);
            }
        }
        return minHeap.isEmpty()?0:minHeap.peek();
    }
}
