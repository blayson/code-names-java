package cz.mendelu.pjj;
public class AddAnExistingWordException extends IllegalArgumentException {
    @Override
    public String toString() {
        return "Pokus o pridani uz existujiciho slova";
    }
}
