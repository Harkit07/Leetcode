class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> nums = new ArrayList<>();
        int startRow = 0, startCol=0;
        int endRow = matrix.length-1, endCol = matrix[0].length-1;

        while(startRow<=endRow && startCol<=endCol){
            for(int i=startCol; i<=endCol; i++){
                nums.add(matrix[startRow][i]);
            }
            for(int i=startRow+1; i<=endRow; i++){
                nums.add(matrix[i][endCol]);
            }
            if(startRow<endRow){
                for(int i=endCol-1; i>=startCol; i--){
                nums.add(matrix[endRow][i]);
               }
            }
            if(startCol<endCol){
                 for(int i=endRow-1; i>= startRow+1; i--){
                nums.add(matrix[i][startCol]);
                }
            }
           
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }

        return nums;
    }
}