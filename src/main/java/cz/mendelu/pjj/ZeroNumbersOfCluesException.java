package cz.mendelu.pjj;

/**
 * @author But
 */
public class ZeroNumbersOfCluesException extends IllegalArgumentException {
    @Override
    public String toString() {
        return "Count of word clues should be from 1 to 9";
    }
}
