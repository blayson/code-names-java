package cz.mendelu.pjj;

import java.util.Objects;

public class Word {
    private String value;
    private boolean isChecked;

    public Word(String value) {
        isChecked = false;
        this.value = value;
    }

    public Boolean isChecked() {
        return isChecked;
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
        return isChecked == word.isChecked &&
                value.equals(word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isChecked);
    }
}
