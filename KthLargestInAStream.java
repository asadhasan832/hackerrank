class KthLargest {
    private PriorityQueue<Integer> q;
    private Integer k;
    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>();
        this.k = k;
        for(int num: nums) {
            this.q.add(num);
        }
        while(this.q.size() > k) this.q.poll();
    }
    
    public Integer add(int val) {
        this.q.add(val);
        if(this.q.size() > k) {
            this.q.poll();
        }
        return this.q.peek();
    }
}
