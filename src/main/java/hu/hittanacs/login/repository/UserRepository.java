package hu.hittanacs.login.repository;

import hu.hittanacs.login.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

      List<User> findByUserName(String userName);


}
