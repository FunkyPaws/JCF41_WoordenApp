package woordenapplicatie;

public class WoordenManager {

    public WoordenManager() {
    }

    public String[] splitString(String string) {
        return string.toLowerCase().split("[,\n ]+");
    }
}
