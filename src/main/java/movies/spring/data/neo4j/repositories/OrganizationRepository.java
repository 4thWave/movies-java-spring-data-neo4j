package movies.spring.data.neo4j.repositories;

import java.util.Collection;

import movies.spring.data.neo4j.domain.Organization;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@RepositoryRestResource(collectionResourceRel = "organizations", path = "organizations")
public interface OrganizationRepository extends PagingAndSortingRepository<Organization, Long> {

    Organization findByTitle(@Param("name") String title);

    Collection<Organization> findByTitleLike(@Param("title") String title);

    @Query("MATCH (m:Organization)-[r:SURGING_ON]->(a:Topic) RETURN m,r,a LIMIT {limit}")
    Collection<Organization> graph(@Param("limit") int limit);
}

