class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Set<List<Integer>>ans = new HashSet<>();
        for(int i = 0; i < n; i++){
            Set<Integer>hashset = new HashSet<>();
            for(int j = i+1; j<n; j++){
                int third = -(nums[i]+nums[j]);
                if(hashset.contains(third)){
                    List<Integer>temp = Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                hashset.add(nums[j]);
            }
        }
        return new ArrayList<>(ans);
    }
}