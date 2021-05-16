package BonEsprit.Service;

import BonEsprit.DAO.CertificateDAO;
import BonEsprit.DAO.UserDAO;
import BonEsprit.Exception.SignUpException;
import BonEsprit.Exception.UserNameExistedException;
import BonEsprit.Model.Certificate;
import BonEsprit.Model.User;
import BonEsprit.Model.UserType;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {

//    private static final UserDAO userDAO = new UserDAO();
//    private static final CertificateDAO certificateDAO = new CertificateDAO();

    public static DATA myData = new DATA();
    public static String signUp(User user) {
        /*
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
        */
        DATA.users.add(user);
        return "Sign Up Sucessfully";
    }

    public static User logIn(String username, String password) {
        /*try {
            if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
                return new User(0L);
            }
            return userDAO.logIn(username, password);


        } catch (Exception e) {
            return new User(0L);
        }*/
        for(int i = 0; i < DATA.users.size(); i++) {
            User x = DATA.users.get(i);
            if(x.getUserName().equals(username) && x.getPassWord().equals(password))
                return x;
        }
        return new User(0L);
    }

    @SneakyThrows
    public static void updateInfo(User user) {
/*        User tempUser = user.clone();

        tempUser.setCertificates(Collections.emptyList());

        userDAO.update(tempUser);

        if (user.getTypeUser() != UserType.THERAPIST.getValue()) {
            return;
        }

        certificateDAO.update(user.getCertificates());

 */

    }


    public static List<User> mostHorable() {
//        return userDAO.mostCertificates(5);
        List<User> result = new ArrayList<User>();
        for(int i = 0; i < DATA.users.size(); i++)
        {
            if(DATA.users.get(i).getTypeUser() == UserType.THERAPIST.getValue())
                result.add(DATA.users.get(i));
        }
        return result;
    }

    public static List<Certificate> getCertificate(Long ID) {
//        return certificateDAO.readByUser(ID);
        List<Certificate> result = new ArrayList<Certificate>();
        for(int i = 0; i < DATA.users.size(); i++) {
            User x = DATA.users.get(i);
            if(x.getID() == ID) {
                for(int j = 0; j < x.getCertificates().size(); j++)
                    result.add(x.getCertificates().get(j));
                break;
            }

        }
        return result;
    }

    public boolean delete(long userId) {
  //      return userDAO.delete(userId);
        for(int i = 0; i < DATA.users.size(); i++)
        {
            if(DATA.users.get(i).getID() == userId) {
                DATA.users.remove(i);
                return true;
            }
        }
        return false;
    }


}
