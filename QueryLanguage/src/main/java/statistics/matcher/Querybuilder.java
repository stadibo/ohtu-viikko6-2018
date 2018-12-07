/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;

/**
 *
 * @author peje
 */
public class Querybuilder {
    ArrayList<Matcher> matchers;    

    public Querybuilder() {
        this.matchers = new ArrayList<>();
    }
    
    public Matcher build() {
        if (matchers.isEmpty()) {
            Matcher m = new All();
            matchers.clear();
            return m;
        } else {
            Matcher m = new And(matchers.toArray(new Matcher[matchers.size()]));
            matchers.clear();
            return m;
        }
    }
    
    public Querybuilder oneOf(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
    
    public Querybuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }
    
    public Querybuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public Querybuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    
}
