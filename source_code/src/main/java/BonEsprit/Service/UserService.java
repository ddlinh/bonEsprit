package BonEsprit.Service;

import BonEsprit.DAO.CertificateDAO;
import BonEsprit.DAO.UserDAO;
import BonEsprit.Exception.SignUpException;
import BonEsprit.Exception.UserNameExistedException;
import BonEsprit.Model.User;
import BonEsprit.Model.UserType;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;

public class UserService {

    private static final UserDAO userDAO = new UserDAO();
    private static final CertificateDAO certificateDAO = new CertificateDAO();

    public static String signUp(User user) {
        try {
            User existUser = userDAO.readByUsername(user.getUserName());

            if(existUser == null) {
                return "Error Occurred";
            }

            if(existUser.getID() == 0) {
                return "Username Existed";
            }

            userDAO.create(user);

            return "Successfully Sign Up";
        } catch (Exception e) {
            return "Error Occurred";
        }
    }

    public User logIn(String username, String password) {
        try {
            if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
                return new User(0L);
            }

            return userDAO.logIn(username, password);
        } catch (Exception e) {
            return new User(0L);
        }
    }

    @SneakyThrows
    public void updateInfo(User user) {
        User tempUser = user.clone();

        tempUser.setCertificates(Collections.emptyList());

        userDAO.update(tempUser);

        if (user.getTypeUser() != UserType.THERAPIST.getValue()) {
            return;
        }

        certificateDAO.update(user.getCertificates());
    }

    public boolean delete(long userId) {
        return userDAO.delete(userId);
    }
}
