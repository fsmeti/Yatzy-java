public enum Category {
    PAIR(2),
    THREE_OF_A_KIND(3),
    FOUR_OF_A_KIND(4);

    private int value;

    Category(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
