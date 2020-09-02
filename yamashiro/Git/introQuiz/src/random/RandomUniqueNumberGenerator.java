package random;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUniqueNumberGenerator{

	/*
	 *  0 から 「引数２(no)」 までの数で、なおかつ、重複しない乱数を
	 *  「引数１(hashSize)」個 生成するメソッド
	 */
    public static int[] randomNoGenerator(int hashSize, int no){
        Random random = new Random();

        Set<Integer> set = new HashSet<Integer>(hashSize) {
        	{
		        for(int i = 0; i < hashSize; i++) {
		            add(random.nextInt(no));
		        }
        	}
        };

        Integer[] wrapInt = set.toArray(new Integer[set.size()]);
        int[] ptimitivInt = new int[set.size()];

        for(int i = 0; i < set.size(); i++) {
        	ptimitivInt[i] = wrapInt[i].intValue();
        }

        return ptimitivInt;
    }

    public static void main(String[] args) {
    	for(int i = 0; i < 5; i++) {
    		System.out.println(RandomUniqueNumberGenerator.randomNoGenerator(5, 50)[i]);
    	}

	}
}