package ro.teamnet.javadays.meet1;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: gerard.dragoi
 * Date: 5/3/12
 * Time: 9:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class PrimitiveArrayOperations {
    public static int[] intersect(int[] x,int[] y) {
       // return theClassicalWay(x, y);
       final List<int[]> first = Arrays.asList(x);
       final List<int[]> second = Arrays.asList(y);
        final boolean b = first.retainAll(second);

        return null;


    }

    private static int[] theClassicalWay(int[] x, int[] y) {
        int index=0;
        int[] intersect =new int[Math.min(x.length,y.length)];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<y.length;j++){
               if(x[i]==y[j]){
                   intersect[index++]=x[i];
               }

            }
        }
        int[] copy= new int[index];
        System.arraycopy(intersect,0,copy,0,index);
        return  copy;
    }

    public static void main(String[] args) {
        final int[] intersect = theClassicalWay(new int[]{1, 2, 3}, new int[]{7, 3, 4});

        System.out.println(Arrays.toString(intersect));
    }
}
