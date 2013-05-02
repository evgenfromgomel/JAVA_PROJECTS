/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.gstu.resultanalyzer.entities;

import java.util.ArrayList;

/**
 *
 * @author evgen
 */
public class Signal {
    
    private ArrayList<Count> counts;

    public void setCounts(ArrayList<Count> counts) {
        this.counts = counts;
    }

    public ArrayList<Count> getCounts() {
        return counts;
    }
    
    
}
