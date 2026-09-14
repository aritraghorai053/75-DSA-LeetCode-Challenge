class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // rec = [x1, y1, x2, y2]

        // Check if there is a gap between rectangles
        if (rec1[2] <= rec2[0] ||   // rec1 is left of rec2
            rec2[2] <= rec1[0] ||   // rec2 is left of rec1
            rec1[3] <= rec2[1] ||   // rec1 is below rec2
            rec2[3] <= rec1[1]) {   // rec2 is below rec1

            return false;
        }

        return true;
    }
}