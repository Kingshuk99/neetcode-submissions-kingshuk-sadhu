class Solution {
    public boolean alphaNumeric(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') ||
        (ch >= '0' && ch <= '9');
    }
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;

        while(left < right) {
            while(left < right && !alphaNumeric(s.charAt(left))) {
                left++;
            }

            while(left < right && !alphaNumeric(s.charAt(right))) {
                right--;
            }

            if((left < right) && (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
