/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author anubhav
 */
public class Assignment4 {

    /**
     * @param keyboard
     * @return
     */
    public static int option(Scanner keyboard) {
        int op = 0;
        while (op < 1 || op > 6) {
            System.out.println("Choose an option");
            System.out.println("1.Find word");
            System.out.println("2.Change Definition");
            System.out.println("3.Add word/definition ");
            System.out.println("4.Delete Word");
            System.out.println("5.Browse");
            System.out.println("6.Quit");
            op = keyboard.nextInt();
        }
        return op;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new FileInputStream("dict.txt"));
        String[][] dict = new String[40000][2];
        Scanner keyboard = new Scanner(System.in);
        Dictionary h = new Dictionary();
        h.load();
       
        System.out.println("Welcome");
        for (;;) {
            int op = option(keyboard);

            if (op == 1) {
                System.out.println("Enter word");
                String word = keyboard.next();
                if (h.find(word) != null) {
                    System.out.println(h.find(word));
                }
                if (h.find(word) == null) {
                    System.out.println("Word Not found");
                }
            }

            if (op == 2) {
                System.out.println("Enter word");
                String word = keyboard.next();
                keyboard.nextLine();
                if (h.find(word) == null) {
                    System.out.println(" Word Not found");
                }
                else if (h.find(word) != null) {
                    System.out.println("Enter new definition");
                    String meaning = keyboard.nextLine();
                    DictionaryEntry de = new DictionaryEntry(word, meaning);
                    h.replace(word,de);
                }
            }

            if (op == 3) {
                System.out.println("Enter word");
                String word = keyboard.next();
                keyboard.nextLine();
                if (h.find(word) != null) {
                    System.out.println("Word already exists");
                }
                else if (h.find(word) == null) {
                    System.out.println("Enter meaning");
                    String meaning = keyboard.nextLine();
                    DictionaryEntry de = new DictionaryEntry(word, meaning);
                    h.add(word, de);
                }
            }

            if (op == 4) {
                System.out.println("Enter word to be removed from dictionary");
                String word = keyboard.next();
                System.out.println(h.delete(word));
            }

            if (op == 5) {
                System.out.println("Enter keyword");
                String letter = keyboard.next();
                System.out.println(h.browse(letter));
            }

            if (op == 6) {
                System.out.println("-----Thank you------");
                return;
            }
        }
    }
}
