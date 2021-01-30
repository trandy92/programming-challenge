package de.exxcellent.challenge;


import java.util.List;
import java.util.Map;

/**
 * This interface forces to return Data Structure from any given source that implements it:
 * {0->{{"HeaderColumn1" : value1},{"HeaderColumn2" : value2}},
 *  1->{{"HeaderColumn1" : value1},{"HeaderColumn2" : value2}}
 * author: Andreas Reichel
 */
public interface DataFactory {
    public List<Map<String, String>> getData();
}
