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

   // @Query("MATCH (n:Organization)-[s:SURGING_ON]->(t:Topic) WHERE t.name = \"Graph Databases\" and s.weight>80  RETURN n,s,t  LIMIT {limit}")

    @Query("MATCH (n:IndustrySize)-[:ORG_SIZED_AS]->(o:Organization)-[s:SURGING_ON]->(t:Topic)-[:HAS_A]->(c:Category) WHERE s.weight>80 and s.confidence='A'  and n.name = 'Small (10 - 49 Employees)' AND s.weight>82  RETURN n,o,s,t,c LIMIT {limit}")
    Collection<Organization> graph(@Param("limit") int limit);
}

