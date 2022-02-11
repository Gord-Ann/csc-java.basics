package anna.sixth.stream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {
    /**

     */
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> n * n / 10 % 1000);
    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
        if (!items.isEmpty()) {
            minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));

        } else {
            minMaxConsumer.accept(null, null);
        }
    }

    public void countWords (){
        HashMap<String, Integer> result = new HashMap<>();

        (new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)))
                .lines()
                .flatMap(l -> Stream.of(l.split("[\\p{Punct}\\s]+")))
                .map(String::toLowerCase)
                .forEach(w -> {
                    if(result.containsKey(w)) result.put(w, result.get(w) + 1);
                    else result.put(w, 1);
                });

        result.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    if(e1.getValue() == e2.getValue()) return e1.getKey().compareTo(e2.getKey());
                    else return e2.getValue().compareTo(e1.getValue());})
                .limit(10)
                .forEach(e -> System.out.println(e.getKey()));
    }

}

