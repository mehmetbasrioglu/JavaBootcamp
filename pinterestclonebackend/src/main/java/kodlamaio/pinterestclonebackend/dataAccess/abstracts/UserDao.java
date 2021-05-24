package kodlamaio.pinterestclonebackend.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.pinterestclonebackend.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
