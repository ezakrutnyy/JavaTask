package mock;

import java.util.Objects;

public class UserService {

    private final UserRepository userRepository;

    private final PasswordEnconder passwordEnconder;

    public UserService(UserRepository userRepository, PasswordEnconder passwordEnconder) {
        this.userRepository = userRepository;
        this.passwordEnconder = passwordEnconder;
    }

    public boolean isValidUser(Long id, String password) {

        User user = userRepository.findById(id);

        return isEnabledUser(user) && isValidPassword(user, password);

    }

    private boolean isEnabledUser(User user) {
        return !Objects.isNull(user) && user.isEnabled();
    }

    private boolean isValidPassword(User user, String password) {
        String encodedPassword = passwordEnconder.encode(password);
        return encodedPassword.equals(user.getPasswordHash());
    }
}