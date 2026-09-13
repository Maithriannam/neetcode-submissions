class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add all initial numbers
        for (int n : nums) {
            add(n);
        }
    }

    public int add(int val) {
        minHeap.offer(val); // add new value

        // Maintain size of heap = k
        if (minHeap.size() > k) {
            minHeap.poll(); // remove smallest
        }

        return minHeap.peek(); // top = kth largest
    }
}

