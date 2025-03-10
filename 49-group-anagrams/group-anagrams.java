import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];

            // Count character frequencies
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }

            // Build the key using StringBuilder
            StringBuilder freqPattern = new StringBuilder();
            for (int charFreq : freq) {
                freqPattern.append(charFreq).append("#");  // Append a delimiter
            }
            String key = freqPattern.toString();

            // Store in hashmap
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
