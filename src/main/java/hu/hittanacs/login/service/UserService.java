package hu.hittanacs.login.service;

import hu.hittanacs.login.model.User;
import hu.hittanacs.login.repository.UserRepository;
import hu.hittanacs.login.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public List<User> getAllUser(String userName){
        System.out.println(EncryptUtil.getEncryptedString(userName));

        return userRepository.findByUserName(EncryptUtil.getEncryptedString(userName));
    }
}
