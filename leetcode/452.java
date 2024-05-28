https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/

// first approach
//time complexity - n log n
//  space - o(1)

  class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));
        if(points.length == 0){
            return 0;
        }
        // Arrays.sort(points , (a,b)->{
        //     if(a[0]==b[0]){
        //         return a[1]-b[1];
        //     }else{
        //         return a[0]-b[0];
        //     }
        // });
        int count=1;
        int end = points[0][1];
        for(int i=1; i<points.length ; i++){
            if(points[i][0] > end){
                count++;
                 end = points[i][1];
            }
            
        }
        return count;

    }
}
//2nd approach time and space n log n
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> Integer.compare(a[1],b[1]));
        
        // Arrays.sort(points , (a,b)->{
        //     if(a[0]==b[0]){
        //         return a[1]-b[1];
        //     }else{
        //         return a[0]-b[0];
        //     }
        // });
        Stack<int[]> st =new Stack<>();
        for(int i=0; i<points.length ; i++){
            if(!st.isEmpty() && (long)points[i][0] <= (long)st.peek()[1]){
                int[] val = st.pop();
                points[i][0]= Math.max(points[i][0], val[0]);
                points[i][1]= Math.min(points[i][1], val[1]);
            }
            st.push(points[i]);
            System.out.println(i + ":" + st.size());
        }
        return st.size();

    }
}
  
