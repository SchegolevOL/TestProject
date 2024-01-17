package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConverterTest extends TestCase {
    Path myPath = Paths.get(Main.PATH, "testproject", "test", "main", "resources", "test.json");


    @Test
    public void testToJavaObject() {

    }
}