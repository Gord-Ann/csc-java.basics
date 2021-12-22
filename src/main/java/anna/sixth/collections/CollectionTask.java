package anna.sixth.collections;

import java.util.HashSet;
import java.util.Set;

public class CollectionTask {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> resultSet = new HashSet<T>();
        resultSet.addAll(set1);
        resultSet.addAll(set2);

        resultSet.removeIf(item -> set1.contains(item) && set2.contains(item));

        return resultSet;
    }
}
