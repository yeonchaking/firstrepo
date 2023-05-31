import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[][] book_time = new String[n][2];

		for (int i = 0; i < n; i++) {
			book_time[i][0] = sc.next();
			book_time[i][1] = sc.next();
		}

		System.out.println(Solution.solution(book_time));

	}

	static class Solution {
		public static int solution(String[][] book_time) {
			int answer = 0;

			int[] cnt = new int[1440];

			for (int i = 0; i < book_time.length; i++) {

				String str1 = book_time[i][0];
				int start = (str1.charAt(0)-'0') * 600 + (str1.charAt(1)-'0') * 60 + (str1.charAt(3)-'0') * 10 + (str1.charAt(4)-'0');
				String str2 = book_time[i][1];
				int end = (str2.charAt(0)-'0') * 600 + (str2.charAt(1)-'0') * 60 + (str2.charAt(3)-'0') * 10 + (str2.charAt(4)-'0');

				for (int j = start; j < Math.min(end + 10, 1440); j++) {
					cnt[j]++;
				}
			}
			int max = 0;
			for (int i = 0; i < 1440; i++) {
				max = max > cnt[i] ? max : cnt[i];
			}
			answer = max;

			return answer;
		}
	}

}