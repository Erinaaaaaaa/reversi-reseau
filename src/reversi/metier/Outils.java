package reversi.metier;

import java.util.*;

public class Outils
{
    public static LinkedHashMap<Joueur, Integer> sortHashMapByValues(
            HashMap<Joueur, Integer> passedMap) {
        List<Joueur> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapKeys);
        Collections.sort(mapValues);

        Collections.reverse(mapKeys);
        Collections.reverse(mapValues);

        LinkedHashMap<Joueur, Integer> sortedMap =
                new LinkedHashMap<>();

        for (Integer val : mapValues)
        {
            Iterator<Joueur> keyIt = mapKeys.iterator();

            while (keyIt.hasNext())
            {
                Joueur key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2))
                {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}
