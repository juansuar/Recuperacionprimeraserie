package org.example;

import java.util.*;

public class CrosswordValidator {

    private final Set<String> dictionary;

    public CrosswordValidator(List<String> validWords) {
        this.dictionary = new HashSet<>(validWords);
    }

    public boolean isValidBoard(char[][] board) {
        return validateRows(board) && validateColumns(board);
    }

    private boolean validateRows(char[][] board) {
        for (char[] row : board) {
            if (!validateLine(new String(row))) return false;
        }
        return true;
    }

    private boolean validateColumns(char[][] board) {
        int size = board.length;
        for (int col = 0; col < size; col++) {
            StringBuilder sb = new StringBuilder();
            for (int row = 0; row < size; row++) {
                sb.append(board[row][col]);
            }
            if (!validateLine(sb.toString())) return false;
        }
        return true;
    }

    private boolean validateLine(String line) {
        for (String word : line.split("#")) {
            if (word.length() >= 2 && !dictionary.contains(word)) {
                return false;
            }
        }
        return true;
    }
}
