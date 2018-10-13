package hu.hittanacs.login.repository;

import hu.hittanacs.login.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

      void deleteById(Long Id);
      User save(User user);
      Optional<User> findById(Long id);

}
