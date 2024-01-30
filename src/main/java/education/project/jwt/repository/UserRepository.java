package education.project.jwt.repository;

import education.project.jwt.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @EntityGraph(attributePaths = "authorities") //쿼리가 수행이 될 때, Lazy 조회가 아닌 Eager 조회로 Authorities 정보를 같이 가져오게 된다.
    Optional<User> findOneWithAuthoritiesByUsername(String username);

}