/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package netapp.lib.entities;

import netapp.lib.params.UserParams;

/**
 *
 * @author Usser
 */
public class User {
    
    private String name;
    private UserParams params;

    public String getName() {
        return name;
    }

    public UserParams getParams() {
        return params;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParams(UserParams params) {
        this.params = params;
    }
    
    
    
}
