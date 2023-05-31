import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static char[][] arr;
	static int[][][] cntArr;
	static Queue<Integer> q1;
	static Queue<Integer> q2;
	static Queue<Integer> q3;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new char[N][M];
		cntArr = new int[N][M][2];
		int result = Integer.MAX_VALUE;
		int starti = 0;
		int startj = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == '0') {
					starti = i;
					startj = j;
				}
			}
		}

		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		q3 = new LinkedList<>();

		BFS(starti, startj);
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("---------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(cntArr[i][j][1] + " ");
			}
			System.out.println();
		}
		System.out.println("-------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(cntArr[i][j][0] + " ");
			}
			System.out.println();
		}
		System.out.println("-------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					result = Math.min(cntArr[i][j][0], result);
				}
			}
		}
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	private static void BFS(int r, int c) {
		q1.add(r); // 행
		q2.add(c); // 열

		cntArr[r][c][1] = 1;
		while (!q1.isEmpty()) {
			int currr = q1.poll();
			int currc = q2.poll();

			for (int k = 0; k < 4; k++) {
				if (currr + dr[k] >= N || currr + dr[k] < 0 || currc + dc[k] >= M || currc + dc[k] < 0) {
					continue;
				}
				if (arr[currr + dr[k]][currc + dc[k]] == 'a' && cntArr[currr + dr[k]][currc + dc[k]][1] == 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0] + (1 << 1);
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'b' && cntArr[currr + dr[k]][currc + dc[k]][1] == 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0] + (1 << 2);
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'c' && cntArr[currr + dr[k]][currc + dc[k]][1] == 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0] + (1 << 3);
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'd' && cntArr[currr + dr[k]][currc + dc[k]][1] == 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0] + (1 << 4);
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'e' && cntArr[currr + dr[k]][currc + dc[k]][1] == 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0] + (1 << 5);
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'f' && cntArr[currr + dr[k]][currc + dc[k]][1] == 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0] + (1 << 6);
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				}

				if (arr[currr + dr[k]][currc + dc[k]] == 'A'
						&& (cntArr[currr + dr[k]][currc + dc[k]][0] & (1 << 1)) != 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0];
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'B'
						&& (cntArr[currr + dr[k]][currc + dc[k]][0] & (1 << 2)) != 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0];
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'C'
						&& (cntArr[currr + dr[k]][currc + dc[k]][0] & (1 << 3)) != 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0];
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'D'
						&& (cntArr[currr + dr[k]][currc + dc[k]][0] & (1 << 4)) != 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0];
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'E'
						&& (cntArr[currr + dr[k]][currc + dc[k]][0] & (1 << 5)) != 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0];
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				} else if (arr[currr + dr[k]][currc + dc[k]] == 'F'
						&& (cntArr[currr + dr[k]][currc + dc[k]][0] & (1 << 6)) != 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0];
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;

				}
				if ((arr[currr + dr[k]][currc + dc[k]] == '.' || arr[currr + dr[k]][currc + dc[k]] == '0')
						&& cntArr[currr + dr[k]][currc + dc[k]][1] == 0) {
					cntArr[currr + dr[k]][currc + dc[k]][0] = cntArr[currr][currc][0];
					q1.add(currr + dr[k]);
					q2.add(currc + dc[k]);
					cntArr[currr + dr[k]][currc + dc[k]][1] = cntArr[currr][currc][1] + 1;
				}
				System.out.println("q1" +q1);
				System.out.println("q2" +q2);
			}

		}

	}
}