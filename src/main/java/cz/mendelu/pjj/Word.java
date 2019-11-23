package cz.mendelu.pjj;

import java.util.Objects;

public class Word {
    private String value;
    private boolean check;

    public Word(String value) {
        this.value = value;
    }

    public Boolean isChecked() {
        return null;
    }

    public String getValue() {
        return value;
    }

    public void check() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return check == word.check &&
                value.equals(word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, check);
    }
}
