package cz.mendelu.pjj;


import cz.mendelu.pjj.domain.Board;
import cz.mendelu.pjj.domain.Word;
import cz.mendelu.pjj.io.WordsReader;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardTest { // nado sdelat interface Word?

    @Test
    void generate25Words() {
        // given
        Board board = WordsReader.read("words.json");
        List<Word> words;
        // when
        words = board.getWordList();
        // then
        assertEquals(25, words.size());
        assertNotNull(words.get(0));
        assertNotNull(words.get(1));
        assertNotNull(words.get(2));
        assertNotNull(words.get(24));
    }
}
