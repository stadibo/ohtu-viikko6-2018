package statistics.matcher;

import statistics.Player;

/**
 *
 * @author peje
 */
public class All implements Matcher {

    private Matcher[] matchers;
    
    public All(Matcher... matchers) {
        this.matchers = matchers;
    }

    @Override
    public boolean matches(Player p) {
        return true;
    }
    
}
