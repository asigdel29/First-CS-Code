/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author anubhav
 */
public class Dictionary {

    HashMap<String, DictionaryEntry> map = new HashMap<>();

    public void load() throws FileNotFoundException {
        Scanner reader = new Scanner(new FileInputStream("dict.txt"));
        while (reader.hasNext()) {
            String s = reader.nextLine();
            String[] values = new String[2];
            values = s.split("\t");
            DictionaryEntry d = new DictionaryEntry(values[0], values[1]);
            map.put(values[0], d);
        }
    }

    public ArrayList browse(String letter) {
        ArrayList a = new ArrayList();
        for (String w : map.keySet()) {
            if (w.indexOf(letter) == 0) {
                a.add(w + ":" + map.get(w));
            }
        }
        return a;
    }

    public String find(String word) {
        if (map.get(word) != (null)) {
            return (word + ":" + map.get(word));
        } else {
            return null;
        }
    }

    public boolean add(String word, DictionaryEntry meaning) {
        if (find(word) == (null)) {
            map.put(word, meaning);
            System.out.println("Word added");
            System.out.println(word + ":" + meaning);
            return true;
        } else {
            return false;
        }
    }

    public boolean replace(String word, DictionaryEntry meaning) {
        if (find(word) != (null)) {
            map.put(word, meaning);
            System.out.println("Word replaced");
            System.out.println(word + ":" + meaning);
            return true;
        } else {
            return false;
        }
    }

    public boolean delete(String word) {
        if (find(word) != null) {
            System.out.println("Word found");
            System.out.println(word + ":" + map.get(word));
            map.remove(word);
            System.out.println("Word deleted");
            return true;
        } else {
            System.out.println("Word not found");
            return false;
        }
    }
}
