import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] A = new int[num+1]; // A[i] = i를 제곱수로 나타냈을때, 필요한 항의 최소 개수

        // Bottom-Up 방식
        // 점화식 : A[i] = min(A[i-j*j] + 1) (1 <= j*j <= i)
        for (int i=0;i<num+1;i++) {
            if (i == 0) A[0] = 0;
            A[i] = i; // n를 제곱수로 표현한 최대 항의 개수는 모든 항을 1*1로 구성한 n개이다.
            for (int j=1;j*j<=i;j++) {
                if (A[i-j*j]+1 < A[i]) {
                    A[i] = A[i-j*j] + 1;
                }
            }
        }
        System.out.println(A[num]);
    }
}
