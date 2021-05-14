package BonEsprit.UI;

import BonEsprit.Model.User;

public class UserManager {
    private static long id = -1;
    private static User user;

    public static User get() {
        return user;
    }

    public static synchronized void set(User _user) {
        if (id == -1 && _user.getID() > 0) {
            id = _user.getID();
            user = _user;

            return;
        }

        if (id != _user.getID()) {
            return;
        }

        user = _user;
    }
}