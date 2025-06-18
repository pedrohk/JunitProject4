package org.service.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testReverseSimpleString() {
        assertEquals("olleh", stringUtils.reverse("hello"));
    }

    @Test
    void testReverseStringWithSpaces() {
        assertEquals("dlrow olleh", stringUtils.reverse("hello world"));
    }

    @Test
    void testReverseEmptyString() {
        assertEquals("", stringUtils.reverse(""));
    }

    @Test
    void testReverseNullInput() {
        assertNull(stringUtils.reverse(null));
    }

    @Test
    void testReverseSingleCharacterString() {
        assertEquals("a", stringUtils.reverse("a"));
    }
}