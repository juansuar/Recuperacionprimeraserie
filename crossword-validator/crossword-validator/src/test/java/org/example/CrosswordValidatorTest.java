package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CrosswordValidatorTest {

    @Test
    void testValidBoard() {
        char[][] board = {
            {'H','E','L','L','O','W','O','R','L','D'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'J','A','V','A','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'C','O','D','E','#','C','A','T','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'P','Y','T','H','O','N','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','#','#','#','#','#','#','#','#','#'},
        };

        List<String> dictionary = List.of("HELLO", "WORLD", "JAVA", "CODE", "CAT", "PYTHON");
        CrosswordValidator validator = new CrosswordValidator(dictionary);
        assertTrue(validator.isValidBoard(board));
    }

    @Test
    void testInvalidBoard() {
        char[][] board = {
            {'H','E','L','L','O'},
            {'A','B','C','D','E'},
            {'X','Y','Z','Q','W'},
            {'#','#','#','#','#'},
            {'C','A','T','#','R'},
        };

        List<String> dictionary = List.of("HELLO", "CAT");
        CrosswordValidator validator = new CrosswordValidator(dictionary);
        assertFalse(validator.isValidBoard(board));
    }
}
