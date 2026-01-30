
import java.util.ArrayList;
import java.util.List;


class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(nums , 0 , ans , new ArrayList<>());
        return ans;
    }
    public void findSubsets(int[] nums , int i , List<List<Integer>> ans , List<Integer> subList){
        if(i == nums.length){
            ans.add(new ArrayList<>(subList));
            return;
        }
        //taking
        subList.add(nums[i]);
        findSubsets(nums , i+1 , ans , subList);
        subList.remove(subList.size()-1);
        findSubsets(nums , i+1 , ans , subList);
    }
}
