package pl.woles.utils;

import java.util.Collection;

/**
 * Useful function to use from collections,list and sets.
 */
public class CollectionsUtils {

    /**
     * Checks if it is empty or missing
     *
     * @param collection collection
     * @return result
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
