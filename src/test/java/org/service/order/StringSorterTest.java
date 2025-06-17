package org.service.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringSorterTest {
    private StringSorter stringSorter;

    @BeforeEach
    void setUp() {
        stringSorter = new StringSorter();
    }

    @Test
    void testSortNaturally() {
        List<String> input = Arrays.asList("Banana", "apple", "Orange", "Grape", "Apple");
        List<String> expected = Arrays.asList("Apple", "Banana", "Grape", "Orange", "apple");
        List<String> actual = stringSorter.sortNaturally(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSortNaturallyEmptyList() {
        List<String> input = Collections.emptyList();
        List<String> expected = Collections.emptyList();
        List<String> actual = stringSorter.sortNaturally(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSortNaturallySingleElement() {
        List<String> input = Collections.singletonList("Hello");
        List<String> expected = Collections.singletonList("Hello");
        List<String> actual = stringSorter.sortNaturally(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSortNaturallyNullInput() {
        List<String> actual = stringSorter.sortNaturally(null);
        assertNull(actual);
    }

    @Test
    void testSortCaseInsensitive() {
        List<String> input = Arrays.asList("Banana", "apple", "Orange", "Grape", "Apple");
        List<String> expected = Arrays.asList("apple", "Apple", "Banana", "Grape", "Orange");
        List<String> actual = stringSorter.sortCaseInsensitive(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSortByLength() {
        List<String> input = Arrays.asList("kiwi", "apple", "a", "banana", "orange");
        List<String> expected = Arrays.asList("a", "kiwi", "apple", "banana", "orange");
        List<String> actual = stringSorter.sortByLength(input);
        assertEquals(expected, actual);
    }

    @Test
    void testSortByLengthWithTies() {
        List<String> input = Arrays.asList("bird", "cat", "dog");
        List<String> expected = Arrays.asList("cat", "dog", "bird");
        List<String> actual = stringSorter.sortByLength(input);
        assertEquals(expected, actual);
    }

    @Test
    void testNaturalSortResultIsSorted() {
        List<String> input = Arrays.asList("Banana", "apple", "Orange", "Grape", "Apple");
        List<String> sortedList = stringSorter.sortNaturally(input);
        assertIsSorted(sortedList, String::compareTo);
    }

    @Test
    void testCaseInsensitiveSortResultIsSorted() {
        List<String> input = Arrays.asList("Banana", "apple", "Orange", "Grape", "Apple");
        List<String> sortedList = stringSorter.sortCaseInsensitive(input);
        assertIsSorted(sortedList, String.CASE_INSENSITIVE_ORDER);
    }

    private <T> void assertIsSorted(List<T> list, Comparator<T> comparator) {
        if (list == null || list.size() <= 1) {
            return; 
        }
        for (int i = 0; i < list.size() - 1; i++) {
            assertTrue(comparator.compare(list.get(i), list.get(i + 1)) <= 0,
                    "List is not sorted at index " + i + ": " + list.get(i) + " vs " + list.get(i + 1));
        }
    }

}
