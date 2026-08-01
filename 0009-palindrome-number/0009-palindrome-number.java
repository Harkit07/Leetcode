class Solution {
    public boolean isPalindrome(int x) {
         int rev = 0;
         int originalNum = x;
         while(x>0){
            int lastDigit = x%10;
            rev=(rev*10)+lastDigit;
            x/=10;
        }
        return rev==originalNum;
    }
}