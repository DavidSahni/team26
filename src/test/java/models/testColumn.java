package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class testColumn {
    @Test
    public void testId() {
        Column c = new Column(5);
        assertEquals(5, c.id);
    }
}
