package de.exxcellent.challenge;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Andreas Reichel <andreas_reichel@online.de>
 * Visible only in this package!
 */
class DataAnalyser {
    public static int getEntryWithSmallestSpread(List<Map<String, String>> data,String headerColumn1, String headerColumn2) {
        Integer entryWithSmallestSpread=null;
        Float smallestSpread = null;
        for (int i = 0; i < data.size(); i++)
        {
            float spread=Math.abs(Float.parseFloat(data.get(i).get(headerColumn1)) - Float.parseFloat(data.get(i).get(headerColumn2)));
            if(entryWithSmallestSpread==null)
            {
                smallestSpread=spread;
                entryWithSmallestSpread=i;
            }else
            {
                if(spread<=smallestSpread)
                {
                    smallestSpread=spread;
                    entryWithSmallestSpread=i;
                }
            }
        }
        return entryWithSmallestSpread;
    }
}
