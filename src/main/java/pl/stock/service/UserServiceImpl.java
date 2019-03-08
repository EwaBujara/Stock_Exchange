package pl.stock.service;


import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.stock.entity.User;
import pl.stock.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void save(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);

    }

    @Override
    public boolean verify(User user) {
        if(userRepository.findByUsername(user.getUsername())!=null){

            return BCrypt.checkpw(user.getPassword(), (userRepository.findByUsername(user.getUsername())).getPassword());
        }
        else return false;
    }

}