/* **************************************************************** *
 * Author: Xueyi Wang                                               *
 * Date: July 22 2014                                               *
 *                                                                  *
 * Algorithm description:                                           *
 * The algorithm implement finding minimum path traverses the array *
 * Return "failure" if there is no such path                        *
 * Otherwise, return the index of such path                         *
 * I used greedy algorithm here.                                    * 
 * The time complexity of this algorithm is O(n^2)                  *
 * The input should be a file name, the file should be in unicode   *
 * **************************************************************** */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ArrayHopper{

    public boolean canReachEnd;

    ArrayHopper() {
        canReachEnd = true;
    }

    public void getHopper(int[] array, ArrayList<Integer> res) {

        int dest = array.length - 1;

        /*Only has 0 in array*/
        if(dest == 0 && array[dest] == 0) {
            canReachEnd = false;
            return;
        } 

        /*Only has one integer greater than 0*/
        if(dest == 0 && array[dest] > 0) {
            res.add(dest);
            return;
        }        
        
        while(dest != 0){
            for(int i = 0; i < dest; i++) {
                /*If there is a path can traverse the array*/
                if(i+array[i] > dest || i+array[i] == dest && array[dest] != 0){
                    /*If the only path reaches the end of array*/
                    if( i+array[i]  == dest && res.isEmpty()) {
                        res.add(dest);
                    }
                    /*Add index of such into arraylist, then go to check previous index*/
                    dest = i;
                    res.add(i);
                    break;    
                } else if(i == dest-1) {    //there is no such path
                    canReachEnd = false;
                    return;
                }  
            }
        }  
    }


    public static void main(String[] args) {
        ArrayHopper hopper = new ArrayHopper();

        if(args.length == 0) {
            System.out.println("Please enter the file path");
            System.exit(-1);
        }

        Scanner sc = null;
        try {
            sc = new Scanner(new File(args[0]));
        } catch (FileNotFoundException e) {
            System.out.println("No File Found");
            System.exit(-1);
        }

        /*Read file*/
        ArrayList<Integer> read = new ArrayList<Integer>();
        while (sc.hasNextInt()) {
            read.add(sc.nextInt());
        }

        int[] array = new int[read.size()];

        /*empty input*/
        if (array.length == 0) {
            System.out.println("0 out");
        } else {
            for (int i = 0; i < array.length; i++) {
                array[i] = read.get(i);
            }
            
            ArrayList<Integer> res = new ArrayList<Integer>();
            
            hopper.getHopper(array, res);
            
            /*no such path*/
            if (!hopper.canReachEnd) {
                System.out.println("failure");
            } else {
                for(int i = res.size() - 1; i >= 0; i--) {
                    System.out.print(res.get(i) + ", ");
                }
                System.out.println("out");
            }
        }
    }
}