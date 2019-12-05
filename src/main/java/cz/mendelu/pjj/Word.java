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
    /**
     * @author Chuprina
     * @version etapa 3
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return isChecked == word.isChecked &&
                value.equals(word.value);
    }
    /**
     * @author Chuprina
     * @version etapa 3
     */
    @Override
    public int hashCode() {

        return Objects.hash(value, isChecked);
    }
    /**
     * @author Chuprina
     * @version etapa 3
     */
    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                ", isChecked=" + isChecked +
                '}';
    }
}
