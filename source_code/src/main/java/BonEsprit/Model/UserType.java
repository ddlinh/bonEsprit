package BonEsprit.Model;



public enum UserType {

    NORMAL(0),THERAPIST(1),DEFAULT(-1);

    int value;

    UserType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public UserType getByValue(int value) {
        switch (value) {
            case 0:
                return NORMAL;
            case 1:
                return THERAPIST;
            default:
                return DEFAULT;
        }
    }

}
