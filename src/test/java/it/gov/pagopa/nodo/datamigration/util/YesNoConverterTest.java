package it.gov.pagopa.nodo.datamigration.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class YesNoConverterTest {

    private YesNoConverter converter;

    @BeforeEach
    void setUp() {
        converter = new YesNoConverter();
    }

    @Test
    void testConvertToDatabaseColumnTrue() {
        String result = converter.convertToDatabaseColumn(true);
        assertEquals("Y", result);
    }

    @Test
    void testConvertToDatabaseColumnFalse() {
        String result = converter.convertToDatabaseColumn(false);
        assertEquals("N", result);
    }

    @Test
    void testConvertToEntityAttributeTrue() {
        Boolean result = converter.convertToEntityAttribute("Y");
        assertTrue(result);
    }

    @Test
    void testConvertToEntityAttributeFalse() {
        Boolean result = converter.convertToEntityAttribute("N");
        assertFalse(result);
    }
}
