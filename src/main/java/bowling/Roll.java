package bowling;

public class Roll {

    private String value;

    public Roll(int charIntValue) {
        value = String.valueOf((char)charIntValue);
    }

    public int getValue() {
        return "/".equals(value) ? 8 : Integer.valueOf(value);
    }
}
