package kr.hs.gbsw.tree.user.repository;

import kr.hs.gbsw.tree.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
