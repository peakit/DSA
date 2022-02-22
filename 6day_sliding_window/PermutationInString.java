import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> record1 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if(record1.containsKey(s1.charAt(i))) {
                Integer count = record1.get(s1.charAt(i));
                count ++;
                record1.put(s1.charAt(i), count);
            } else {
                record1.put(s1.charAt(i), Integer.valueOf(1));
            }
        }

        int left = 0, right = 0;
        while(right < s2.length()) {
            if((right - left + 1) == record1.keySet().size() && allZeroes(record1)) {
                return true;
            }

            if(record1.containsKey(s2.charAt(right))) {
                Integer count = record1.get(s2.charAt(right));
                count --;
                //record1.put(key, value)
            } else {

                left ++;
            }
            right++;
        }
        return false;
    }

    private boolean allZeroes(Map<Character, Integer> record1) {
        boolean isAllZeroes = true;
        for(Entry<Character, Integer> entrySet: record1.entrySet()) {
            if(entrySet.getValue() != 0) {
                isAllZeroes = false;
                break;
            }
        }
        return isAllZeroes;
    }

    public static void main(String[] args) {
        Scanner in = null;
        try {
            PermutationInString permutationInString = new PermutationInString();

            in = new Scanner(System.in);
            System.out.println("Enter string1: ");
            String s1 = in.nextLine();

            System.out.println("Enter string2: ");
            String s2 = in.nextLine();
            System.out.println(permutationInString.checkInclusion(s1, s2));
        } finally {
            in.close();
        }
    }
}
