package pl.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.stock.entity.User;

import javax.transaction.Transactional;


@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

}
