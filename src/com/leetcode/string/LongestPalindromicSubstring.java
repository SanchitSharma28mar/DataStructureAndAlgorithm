package com.leetcode.string;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode: 5 (M)
 * 	Given a string s, return the longest palindromic substring in s.
 *
 * @author sanchitsharma
 *
 */
public class LongestPalindromicSubstring {

	private static String findLongestPalindromicSubString(String string) {
		String longest = "";
		int maxLength = 0;
		int length = string.length();
		for(int i = 0; i < string.length(); i++){
			// odd length
			int left = i;
			int right = i;
			while(left >= 0
					&& right < length
					&& string.charAt(left) == string.charAt(right)){
				int currentLength = right - left + 1;
				if(currentLength > maxLength){
					maxLength = currentLength;
					longest = string.substring(left, right + 1);
				}
				left --;
				right ++;
			}


			// even lenth
			left = i;
			right = i + 1;
			while(left >= 0
					&& right < string.length()
					&& string.charAt(left) == string.charAt(right)){
				int currentLength = right - left + 1;
				if(currentLength > maxLength){
					maxLength = currentLength;
					longest = string.substring(left, right + 1);
				}
				left --;
				right ++;
			}
		}
		return longest;
	}

	public static void main(String[] args) {
		String string = """
				busislnescsicxpvvysuqgcudefrfjbwwjcchtgqyajdfwvkypfwshnihjdztgmyuuljxgvhdiwphrweyfkbnjgerkmifbirubhseuhrugwrabnjafnbdfjnufdstjbkuwtnpflffaqmjbhssjlnqftgjiglvvequhapasarlkcvbmkwnkuvwktbgfoaxteprobdwswcdyddyvrehvmxrrjiiidatidlpihkbmmruysmhhsncmfdanafdrfpdtfgkglcqpwrrtvacuicohspkounojuziittugpqjyhhkwfnflozbispehrtrnizowrlzcuollagxwtznjwzcumvedjwokueuqktvvouwnsmpxqvvpuwprezrbobrpnwaccwljchdguubjulyilzvmandjjleitweybqkjttschrjjlebnmponvlktzzcdtuybugggcqffkcffpamauvxfbonjrobgpvlyzveiwemmtdvbjciaytvesnocnjrwodtcokgcuoiicxapmrzpkfphjniuvzjrhbnqndfshoduejyktebgdabidxlkstepuwvtrtgbxaeheylicvhrxddijshcvdadxzsccmainyfpfdhqdanfccqkzlmhsfilvoybqojlvbcixjzqpbngdvesuokbxhkomsiqfyukvspqthlzxdnlwthrgaxhtpjzhrugqbfokrdcyurivmzgtynoqfjbafboselxnfupnpqlryvlcxeksirvufepfwczosrrjpudbwqxwldgjyfjhzlzcojxyqjyxxiqvfhjdwtgoqbyeocffnyxhyyiqspnvrpxmrtcnviukrjvpavervvztoxajriuvxqveqsrttjqepvvahywuzwtmgyrzduxfqspeipimyoxmkadrvrdyefekjxcmsmzmtbugyckcbjsrymszftjyllfmoeoylzeahnrxlxpnlvlvzltwnmldi
				""";
		Instant s = Instant.now();
		String longest = findLongestPalindromicSubString(string);
		System.out.println(longest);
//		String longest2 = findLongestPalindromicSubString_Brute(string);
//		System.out.println(longest2);
		Instant e = Instant.now();
		System.out.println(Duration.between(s, e).toMillis());
	}

	private static String findLongestPalindromicSubString_Brute(String string) {
		char[] chars = string.toCharArray();
		String longestSubstring = "";
		int maxLength = 0;
		List<String> list = new ArrayList<>();
		for(int i = 0; i < chars.length; i++){
			for(int j = i; j < chars.length; j++){
				String substring = string.substring(i, j +1);
				if(isPalindrom(substring)){
					int current = substring.length();
					if(maxLength < current){
						maxLength = current;
						longestSubstring = substring;
					}
				}
			}
		}
		return longestSubstring;
	}

	private static boolean isPalindrom(String substring) {
		int start = 0;
		int end = substring.length() - 1;
		while(start <= end){
			if(substring.charAt(start) != substring.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
}
