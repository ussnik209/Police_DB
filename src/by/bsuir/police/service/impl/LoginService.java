package by.bsuir.police.service.impl;

import by.bsuir.police.coding.PasswordCode;
import by.bsuir.police.dao.impl.UserDaoImpl;
import by.bsuir.police.entity.User;
import by.bsuir.police.validation.LoginDataValidator;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

/**
 * The type Login service.
 */
public class LoginService {

    private UserDaoImpl userDao = new UserDaoImpl();

    /**
     * Search user by login password optional.
     *
     * @param login    the login
     * @param password the password
     * @return the optional
     */
    public Optional<User> searchUserByLoginPassword(String login, String password) {
        Optional<User> result = Optional.empty();

        if (LoginDataValidator.loginCheck(login) && LoginDataValidator.passwordCheck(password)) {
            String utf8Login = new String(login.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            String utf8Password = new String(password.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            Optional<User> user = userDao.searchUserByLogin(utf8Login);

            if (user.isPresent()) {
                User currentUser = user.get();

                if (PasswordCode.comparePasswords(PasswordCode.encode(utf8Password), currentUser.getPassword())) {
                    result = Optional.of(currentUser);
                }
            }
        }
        return result;
    }
}
