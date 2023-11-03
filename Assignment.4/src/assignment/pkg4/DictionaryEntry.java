/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg4;

/**
 *
 * @author anubhav
 */
public class DictionaryEntry {

    String word;
    String meaning;

    DictionaryEntry(String w, String m) {
        word = w;
        meaning = m;
    }

    public String word() {
        return word;
    }

    public String meaning() {
        return meaning;
    }

    public String replace(String newmeaning) {
        return meaning = newmeaning;
    }

    public String toString() {
        return meaning;
    }

}
