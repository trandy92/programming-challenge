package de.exxcellent.challenge;

import java.util.List;
import java.util.Map;

/**
 * This interface enforces to return Data in this format :
 * {0->{{"HeaderColumn1" : value1},{"HeaderColumn2" : value2}},
 *  1->{{"HeaderColumn1" : value1},{"HeaderColumn2" : value2}}
 * author: Andreas Reichel
 */
public interface DataFactory {
    public List<Map<String, String>> getData();
}
