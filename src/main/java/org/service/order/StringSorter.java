package org.service.order;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringSorter {

    public List<String> sortNaturally(List<String> strings) {
        if (strings == null) {
            return null;
        }
        return strings.stream()
                .sorted()
                .collect(Collectors.toList());
    }
    public List<String> sortCaseInsensitive(List<String> strings) {
        if (strings == null) {
            return null;
        }
        return strings.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());
    }
    public List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            return null;
        }
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
    public List<String> sortReverseNaturally(List<String> strings) {
        if (strings == null) {
            return null;
        }
        return strings.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }
}