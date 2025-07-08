
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int Max = 1000;

        //에라토스?? 체 사용하여 소수인지 아닌지 boolean 판별
        boolean[] isPrime = new boolean[Max];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i=2; i*i< Max; i++){
            if(isPrime[i]){
                for(int j=i*i; j<Max; j+=i){
                    isPrime[j]=false;
                }
            }
        }

        //소수만 골라서 배열 만들기
        List<Integer> primes = new ArrayList<>();
        for(int i=2; i<Max; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }

        int [][] result = new int[Max+1][];
        for(int k=7; k< Max; k+=2){
            boolean found = false;
            for(int i=0; i<primes.size(); i++){
                int a = primes.get(i);
                for(int j=i; j< primes.size(); j++){
                    int b = primes.get(j);
                    int c = k - a - b;

                    //오름차순
                    if(c<b) break;//오름차순 안되면 넘어감.
                    if(c<= Max &&  isPrime[c]){
                        result[k]= new int[]{a, b, c};
                        found = true;
                        break;// 일단 무조건 하나만 찾고 말거니까
                    }
                }
                if(found) break; // 정답 찾으면 각 루프 종료
            }
        }

        for(int t=0; t<T; t++){
            int K = sc.nextInt();
            if(result[K] == null){
                System.out.println(0);
            }else {
                int[] combi = result[K];
                System.out.println(combi[0]+ " " +combi[1]+ " " +combi[2]);
            }
        }
        sc.close();



    }
}