import java.util.Scanner;
class Solution {
    public List<Integer> generateRow(int row) {
        List<Integer> ans = new ArrayList<>();
        int num = 1;

        for (int col = 0; col <= row; col++){
            ans.add(num);
            num = num * (row - col) / (col + 1);
        }
        return ans;
    }
    public List<List<Integer>>generate(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++){
            triangle.add(generateRow(i));
        }
        return triangle;
    } 
}