package org.hebronworks.SpringAuthethicationJDBC.repo;


import java.util.Optional;

import org.hebronworks.SpringAuthethicationJDBC.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional <User> findUserByUsername(String userName);
}
