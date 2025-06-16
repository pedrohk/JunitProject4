package org.service.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        // When lengths are equal, natural order is used as a secondary sort criterion
        List<String> expected = Arrays.asList("cat", "dog", "bird");
        List<String> actual = stringSorter.sortByLength(input);
        assertEquals(expected, actual);
    }

}
