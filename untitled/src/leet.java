import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leet {
        public static int optimalStrategyOfGame(int[] coins, int n) {
            Integer myCoin = 0, friendCoin = 0;
            List ls = new ArrayList<>();
            Arrays.stream(coins).mapToObj(operand -> ls.add(operand));

            // Write your code here.
            for (int i = 1; i <= n; i++) {
                Integer max=  Math.max((Integer) ls.getFirst(), (Integer) ls.getLast());
                if(i%2!=0){
                    myCoin+=max;
                }else {
                    friendCoin+=max;
                }
                ls.remove(max);
            }
            return myCoin;
        }
}
