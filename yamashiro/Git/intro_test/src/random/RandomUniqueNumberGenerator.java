package random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUniqueNumberGenerator{




    public static int[] randomNoGenerator(int size){


        List<Integer> list = new ArrayList<>();{
    	    for ( int i = 0; i < size; i++ ) {
    	      list.add(i);
    	    }

        Collections.shuffle(list);
        };

        int[] randomNums = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
        	randomNums[i] = list.get(i).intValue();
        }



//        Random random = new Random();
//
//        Set<Integer> set = new HashSet<Integer>(hashSize) {
//        	{
//		        for(int i = 0; i < hashSize; i++) {
//		            add(random.nextInt(no));
//		        }
//        	}
//        };
//
//        Integer[] wrapInt = set.toArray(new Integer[set.size()]);
//        int[] ptimitivInt = new int[set.size()];
//
//        for(int i = 0; i < set.size(); i++) {
//        	ptimitivInt[i] = wrapInt[i].intValue();
//        }

        return randomNums;
    }

    public static void main(String[] args) {
    	for(int i = 0; i < 50; i++) {
    		System.out.println(RandomUniqueNumberGenerator.randomNoGenerator(50)[i]);
    	}

	}
}