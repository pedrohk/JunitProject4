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
}
