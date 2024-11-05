package jayson.javaapp.passman.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import jayson.javaapp.passman.entity.LoginEntity;

@Repository
public interface LoginRepo extends JpaRepository<LoginEntity, Integer>{
	
	
	@Query(value="SELECT user, email, password, account, url "
			+ "FROM login "
			+ "WHERE user LIKE ?1 ORDER BY user ASC; ", nativeQuery=true)
	public List<LoginEntity> findByUsername(String name);
	
	
	@Query(value="SELECT user, email, password, account, url "
			+ "FROM login "
			+ "where account like ?1 ORDER BY user ASC;", nativeQuery=true)
	public List<LoginEntity> findByAccount(String name);
	
	@Query(value="SELECT user, email, password, account, url "
			+ "FROM login "
			+ "where email like ?1 ORDER BY user ASC;", nativeQuery=true)
	public List<LoginEntity> findByEmail(String id);
	
	@Query(value="SELECT user, email, password, account, url "
			+ "FROM login "
			+ "where user like ?1 "
			+ "or email like ?1 "
			+ "or account like ?1 ORDER BY user ASC;", nativeQuery=true)
	public List<LoginEntity> search(@Param("str") String str);
}
