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
 * @author kyleluka
 */
public class SortingProject {

    public static ArrayList<JPanel> bars = new ArrayList();
    public static Random rand = new Random();
    //Set random amount of elements for the array
    public static int randomInd = rand.nextInt((150 - 10)) + 10;
    public static int arr[] = new int[randomInd];
    public static long start, end;
    public static JFrame window = new JFrame("Visuals");
    public static JPanel content = new JPanel();
    public static JLabel timer = new JLabel();
    public static Border blackline = BorderFactory.createLineBorder(Color.BLACK);
    public static DecimalFormat x = new DecimalFormat("0.000");
    public static int WIDTH = (int) (1000 / arr.length) * arr.length;

    static void printTimes(long vStart, long vEnd, long sortStart, long sortEnd) {
        int n = arr.length;
        long vTime = (vEnd - vStart);
        long sTime = (sortEnd - sortStart);
        System.out.println("\nTook: " + x.format(((double) sTime / 1000000)) + "ms to sort " + n + " different values");
        System.out.println("Took: " + x.format(((double) sTime) / 1000000000) + "s to sort " + n + " different values");
        System.out.println("Took: " + (vTime / 1000000) + "ms to visualize " + n + " sorted values");
        System.out.println("Took: " + x.format((double) vTime / 1000000000) + "s to visualize " + n + " sorted values");
    }

    //Main method 
    public static void main(String args[]) {
        
        System.out.println(randomInd);
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
        int copy[] = arr;
        int n = arr.length;

        
        //Start visual timer
        long start = System.nanoTime();
        paint();

        Quicksort ob = new Quicksort();
        ob.sort(arr, 0, n - 1);
        
        //Get end time of visual sort
        long end = System.nanoTime();

        //Get actual sorting time of array
        long rs = System.nanoTime();
        QuicksortTrue sorted = new QuicksortTrue();
        sorted.sort(copy, 0, n - 1);
        long re = System.nanoTime();
        
        //Print timings
        printTimes(start, end, rs, re);

    }

    //Paint original visuals to JFrame
    public static void paint() {

        //Initialize every "bar" for the JFrame
        for (int i = 0; i < arr.length; i++) {

            bars.get(i).setBackground(Color.WHITE);
            content.add(bars.get(i));
            bars.get(i).setBorder(blackline);
            bars.get(i).setBounds((int) ((WIDTH / arr.length) * i), 500 - arr[i], (int) (WIDTH / arr.length), arr[i]);
            bars.get(i).setVisible(true);

        }

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content.setVisible(true);
        window.add(content);
        window.setResizable(false);
        window.setVisible(true);

        //Must use Thread.sleep() or else there are rendering issues of the visuals
        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Update visuals on JFrame after each stage of sorting
    public static void repaint() {

        content.removeAll();
        for (int i = 0; i < arr.length; i++) {

            bars.get(i).setBackground(Color.WHITE);
            content.add(bars.get(i));
            bars.get(i).setBorder(blackline);
            bars.get(i).setBounds((int) ((WIDTH / arr.length) * i), 500 - arr[i], (int) (WIDTH / arr.length), arr[i]);
            bars.get(i).setVisible(true);
      
        }

        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
