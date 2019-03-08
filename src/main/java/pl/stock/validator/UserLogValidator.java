package pl.stock.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.stock.entity.User;
import pl.stock.repository.UserRepository;
import pl.stock.service.UserService;

@Component
public class UserLogValidator implements Validator {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if(userRepository.findByUsername(user.getUsername()) == null){
            errors.rejectValue("username", "nonExisting.userLog.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(!userService.verify(user)){
            errors.rejectValue("password", "nonMatching.userLog.password");
        }

    }
}
