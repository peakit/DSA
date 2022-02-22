import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> record = new HashMap<>();
        int maxLength = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            if (record.containsKey(s.charAt(right))) {
                left = Math.max(left, record.get(s.charAt(right)) + 1);
            }
            maxLength = Math.max(maxLength, right - left + 1);
            record.put(s.charAt(right), right);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(System.in);
            System.out.println("Enter the string: ");
            String str = in.nextLine();

            LongestSubstring longestSubstringObj = new LongestSubstring();
            int longestSubstring = longestSubstringObj.lengthOfLongestSubstring(str);
            System.out.println(longestSubstring);
        } finally {
            in.close();
        }
    }
}