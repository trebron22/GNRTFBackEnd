package hu.hittanacs.login.service;

import hu.hittanacs.login.model.User;
import hu.hittanacs.login.repository.UserRepository;
import hu.hittanacs.login.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getUser(Long id) {
     try {
         return userRepository.findById(id).get();
     }catch (NoSuchElementException e){
         System.out.println("ide basszál be egy logot faszfej, btw nincs júzered, ezt a szöveget is írd majd át.");
         return new User();
     }
    }

    @Override
    public void removeById(Long id) {
         userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public User upload(User user) {
        System.out.println();
        return userRepository.save(user);
    }
}
