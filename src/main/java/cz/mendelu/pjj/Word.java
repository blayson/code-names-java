package cz.mendelu.pjj;

import java.util.Objects;

public class Word {
    private String value;
    private boolean isChecked;
    private Integer position;

    public Word(String value) {
        isChecked = false;
        this.value = value;
        position = 0;
    }

    public Word(String value, Integer position) {
        isChecked = false;
        this.value = value;
        this.position = position;
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
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return isChecked == word.isChecked &&
                value.equals(word.value) &&
                position.equals(word.position);
    }

    /**
     * @author Chuprina
     * @version etapa 3
     */
    @Override
    public int hashCode() {
        return Objects.hash(value, isChecked, position);
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
                ", position=" + position +
                '}';
    }
}
