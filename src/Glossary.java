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
    public Glossary( int ChapterOfTerm,String NameOfTerm, String DefinitionOfTerm){
        this.chapter = ChapterOfTerm;
        this.term = NameOfTerm;
        this.definition = DefinitionOfTerm;
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
        return "Glossary{" +
                "chapter=" + chapter +
                ", term='" + term + '\'' +
                ", definition='" + definition + '\'' +
                '}';
    }
}
