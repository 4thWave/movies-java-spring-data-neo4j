package movies.spring.data.neo4j.repositories;


import movies.spring.data.neo4j.domain.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
@Repository
public interface TopicRepository extends PagingAndSortingRepository<Topic, Long> {

}
