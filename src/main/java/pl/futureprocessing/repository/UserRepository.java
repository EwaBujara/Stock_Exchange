package pl.futureprocessing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.futureprocessing.entity.User;

import javax.transaction.Transactional;


@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
