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
public class Spectrum {
    
    private ArrayList<Harmonic> harmonics;

    public void setHarmonics(ArrayList<Harmonic> harmonics) {
        this.harmonics = harmonics;
    }

    public ArrayList<Harmonic> getHarmonics() {
        return harmonics;
    }
    
    
}
