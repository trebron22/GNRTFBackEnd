package hu.hittanacs.login.service;

import hu.hittanacs.login.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUser(Long id);
    void removeById(Long id);
    User update(User user);

}
