import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class practice {
	static String[] 토핑 = { "상추","토마토", "패티", "토마토", "치즈" };
	static int N = 5;
	static int R = 3;

	static String[] sel = new String[R];

	public static void main(String[] args) {
		Comb(0, 0);

	}

// idx : 내가 이번 깊이에서 고려할 재료
// sidx : 현재 뽑을 자리
	public static void Comb(int idx, int sidx) {
		// base case
		if (sidx == R) { // 다 뽑았어
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (idx == N) { // 고려 다했어
			return;
		}
		// resursive case
		sel[sidx] = 토핑[idx]; // sidx 자리에 현재 보고 있는 idx토핑을 저장할래
		Comb(idx + 1, sidx + 1); // 이번 재료 썼고, 다음 재료 판단하러 ㄱ
		Comb(idx + 1, sidx); // 이번 재료 안썼고, 다음 재료 판단하러ㄱㄱㄱㄱㄱ
	}
}
