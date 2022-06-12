package lab5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lab5.entity.PostComment2;

//@RepositoryRestResource(collectionResourceRel = "instrument1", path = "instrument")
public interface postCommentsRepository extends JpaRepository<PostComment2, Long> {

//  List<User> findByLastName(@Param("name") String name);

}