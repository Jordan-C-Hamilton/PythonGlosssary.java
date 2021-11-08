import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class Glossary {
    private int chapter;
    private String term;
    private String definition;

    public Glossary(){
        chapter = 1;
        term = "bug";
        definition = "an error in the program";
    }
    public Glossary( String line){
        String[] parts = line.split(",");
        chapter = Integer.parseInt(parts[0]);
        term = parts[1];
        definition = parts[2];
    }

    public int getChapter() {
        return chapter;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glossary glossary = (Glossary) o;
        return chapter == glossary.chapter &&
                term.equals(glossary.term) &&
                definition.equals(glossary.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chapter, term, definition);
    }

    @Override
    public String toString() {
        System.out.println(    "ch." + chapter +
                ", term: '" + term + '\'' +
                ", definition: '" + definition + '\''
        );

        return null;
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetChapter() {
    }

    @Test
    void testGetTerm() {
    }

    @Test
    void testGetDefinition() {
    }

    @Test
    void testSetChapter() {
    }

    @Test
    void testSetTerm() {
    }

    @Test
    void testSetDefinition() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}
