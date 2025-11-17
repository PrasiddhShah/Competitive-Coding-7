// Time Complexity : O(nlog(n-k))
// Space Complexity :O(k)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
 * Approach
 * we are using the max heap to solve the problem,
 * first we sort the values by the meeting start time
 * in the PQ we will using using the end time of the meeting to sort teh queue
 * 
 * idea there is to build a quick and the meeting that is ending the easliert will be on top
 * ew compare if the end time of the top meeting is higher then the start time we will add the meeting to the queue
 * if not then we remove the meeting and add the new meeting;
 * 
 * in the end we return size of queue
 * 
 */

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] num : intervals) {
            if (pq.isEmpty()) {
                pq.add(num);
            } else {
                int[] temp = pq.peek();
                if (temp[1] > num[0]) {
                    pq.add(num);
                } else {
                    pq.poll();
                    pq.add(num);
                }
            }

        }
        return pq.size();

    }
}