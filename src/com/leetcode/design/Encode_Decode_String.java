package com.leetcode.design;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 659 (M)
 */
public class Encode_Decode_String {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public static String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : strs)
            stringBuilder.append(str.length()).append("#").append(str);

        return stringBuilder.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public static List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#')
                j++;

            int lengthOfString = Integer.parseInt(str.substring(i, j));
            i = j + 1 + lengthOfString;
            String substring = str.substring(j + 1, i);
            list.add(substring);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> strs = List.of("we", "say", ":", "yes");
        System.out.println("Original Strings - " + strs);
        String encodedString = encode(strs);
        System.out.println("Encoded String - " + encodedString);
        List<String> decodedStrings = decode(encodedString);
        System.out.println("Decoded Strings - " + decodedStrings);
    }
}
