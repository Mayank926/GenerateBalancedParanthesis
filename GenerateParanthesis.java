package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GenerateParanthesis {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.next());
		while (t > 0) {
			int n = Integer.parseInt(sc.next());
			Solution T = new Solution();
			List<String> ans = T.AllParenthesis(n);
			String[] sequences = ans.toArray(new String[0]);
			Arrays.sort(sequences);
			int k = sequences.length;
			for (int i = 0; i < k; i++) {
				System.out.println(sequences[i]);
			}

			t--;

		}

	}

}

class Solution {

	public List<String> AllParenthesis(int n) {
		List<String> results = new ArrayList<>();
		int o = 0;
		int c = 0;
		int pos = 0;
		char arr[] = new char[2 * n];
		putParanthesis(results, arr, '(', pos, o, c, n);
		return results;
	}

	private void putParanthesis(List<String> results, char[] arr, char bracket, int pos, int o, int c, int n) {
		arr[pos++] = bracket;
		if(bracket == '(')
			o++;
		else 
			c++;
		if (o == n && c == n) {
			String str = new String(arr);
			results.add(str);
			return;
		}
		if ((o - c) >= 0) {
			if (o < n)
				putParanthesis(results, arr, '(', pos, o, c, n);
			if (c < n)
				putParanthesis(results, arr, ')', pos, o, c, n);
		}

	}

}
