Comparator 
PriorityQueue<Integer> pq = 
                    new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
                }
            });

private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element left, Element right) {
            return left.val - right.val;
        }
    };

    
Map.entry
for(Map.Entry<Integer,Set<Integer>> entry : graph.entrySet()) {
	if (entry.getValue().contains(course)) {
		entry.getValue().remove(course);
	if(entry.getValue().size() == 0) {
		queue.offer(entry.getKey());
	}
}

倍增
int index = 1;
while(reader.get(index - 1) < target){
	index = index * 2;
}

判断递增
public static boolean isIncreasing(int[]arr) {
    for(int i=0; i<arr.length;i++)
    {
        if(arr[i]<arr[i+1])
            {
                return true;
            }
    }
    return false;
}

去掉数组中重复的数字
public int deduplication(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}