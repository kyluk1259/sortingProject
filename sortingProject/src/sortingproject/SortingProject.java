/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingproject;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author kyleluka DISCLAIMER: IF FOR ANY REASON YOU ARE LOOKING AT THIS CODE,
 * GO TO QuicksortTrue.java TO SEE THE SORTING ALGORITHM AND NOTHING MORE
 *
 */
public class SortingProject {

    public static ArrayList<JPanel> bars = new ArrayList();
    public static Random rand = new Random();
    //Set random amount of elements for the array
    public static int ind = Integer.parseInt(JOptionPane.showInputDialog("How many elements?"));
    public static int disp = Integer.parseInt(JOptionPane.showInputDialog("Just Sort or Visualize?"));
    public static long sleep;
    public static int arr[] = new int[ind];
    public static long start, end;
    public static JFrame window = new JFrame("Visuals");
    public static JPanel content = new JPanel();
    public static JLabel timer = new JLabel();
    public static Border blackline = BorderFactory.createLineBorder(Color.BLACK);
    public static DecimalFormat x = new DecimalFormat("0.000");
    public static int WIDTH = ((int)(2000/arr.length))*arr.length;
    public static int n = arr.length;

    public static void printTimes(long vStart, long vEnd, long sStart, long sEnd) {
        long vTime = (vEnd - vStart);
        long sTime = (sEnd - sStart);
        System.out.println("\nTook: " + x.format(((double) sTime / 1000000)) + "ms to sort " + n + " different values");
        System.out.println("Took: " + sTime + "ns to sort " + n + " different values");
        System.out.println("Took: " + (vTime / 1000000) + "ms to visualize " + n + " sorted values");
        System.out.println("Took: " + x.format((double) vTime / 1000000000) + "s to visualize " + n + " sorted values");
    }

    //Main method 
    public static void main(String args[]) {

        if (disp == 0) {
            for (int i = 0; i < arr.length; i++) {
                int randomValue = rand.nextInt((500 - 1) + 1) + 1;
                arr[i] = randomValue;
            }
            long rs = System.nanoTime();
            QuicksortTrue sorted = new QuicksortTrue();
            sorted.sort(arr, 0, n - 1);
            long re = System.nanoTime();
            long tot = re - rs;
            System.out.println("\nTook: " + x.format(((double) tot / 1000000)) + "ms to sort " + n + " different values");
            System.out.println("Took: " + tot + "ns to sort " + n + " different values");
            System.exit(0);
        } else {

            sleep = Long.parseLong(JOptionPane.showInputDialog("Sleep Time?"));
            window.setSize(WIDTH, 520);
            content.setSize(window.getSize());
            content.setLayout(null);
            content.setBackground(Color.black);

            //Randomly set the values of each index element between 1-500
            for (int i = 0; i < arr.length; i++) {
                int randomValue = rand.nextInt((500 - 1) + 1) + 1;
                arr[i] = randomValue;
            }

            //Set determined amount of "bars" for visuals
            for (int i = 0; i <= arr.length; i++) {
                bars.add(new JPanel());
            }

            //create a copy of the original array for alternate timing
            int copy[] = arr.clone();

            //Get actual sorting time of array
            long rs = System.nanoTime();
            QuicksortTrue sorted = new QuicksortTrue();
            sorted.sort(copy, 0, n - 1);
            long re = System.nanoTime();

            //Start visual timer
            long start = System.nanoTime();

            paint();
            Quicksort ob = new Quicksort();
            ob.sort(arr, 0, n - 1);

            //Get end time of visual sort
            long end = System.nanoTime();

            //Print timings
            printTimes(start, end, rs, re);
        }
    }

    //Paint original visuals to JFrame
    public static void paint() {

        //Initialize every "bar" for the JFrame
        for (int i = 0; i < arr.length; i++) {

            bars.get(i).setBackground(Color.WHITE);
            content.add(bars.get(i));
            bars.get(i).setBorder(blackline);
            bars.get(i).setBounds((int)((WIDTH / arr.length) * i), 500 - arr[i], (int) (WIDTH / arr.length), arr[i]);
            bars.get(i).setVisible(true);
            bars.get(i).isOptimizedDrawingEnabled();

        }

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.setVisible(true);
        window.add(content);
        window.setResizable(false);
        window.setVisible(true);

        //Must use Thread.sleep() or else there are rendering issues of the visuals
        try {
            Thread.sleep(sleep*10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
