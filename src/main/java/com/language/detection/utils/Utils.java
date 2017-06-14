package com.language.detection.utils;

import com.google.gson.Gson;
import spark.ResponseTransformer;

import java.util.*;

public class Utils {

    public static <K, V> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> ((Comparable<V>) o2.getValue()).compareTo(o1.getValue()));

        Map<K, V> result = new LinkedHashMap<>();
        for (Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<K, V> entry = it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static List<Map.Entry<String, HashSet<String>>> sortHashMapBySize(HashMap<String, HashSet<String>> map) {
        List<Map.Entry<String, HashSet<String>>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, HashSet<String>> o1, Map.Entry<String, HashSet<String>> o2) {
                Integer size1 = new Integer(o1.getValue().size());
                Integer size2 = new Integer(o2.getValue().size());
                return size1.compareTo(size2);
            }
        });

        return list;
    }

    public static String convert2json(Object object) {
        return new Gson().toJson(object);
    }

    public static ResponseTransformer transform2json() {
        return Utils::convert2json;
    }

    public static <K, V> Map<K, V> sortByValue(Map<K, V> map, int limit) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> ((Comparable<V>) o2.getValue()).compareTo(o1.getValue()));

        if (limit > -1) {
            list = list.subList(0, limit);
        }

        Map<K, V> result = new LinkedHashMap<>();
        for (Iterator<Map.Entry<K, V>> it = list.iterator(); it.hasNext(); ) {
            Map.Entry<K, V> entry = it.next();
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
