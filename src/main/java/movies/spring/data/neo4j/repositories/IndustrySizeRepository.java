package movies.spring.data.neo4j.repositories;

import java.util.Collection;

import movies.spring.data.neo4j.domain.IndustrySize;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@RepositoryRestResource(collectionResourceRel = "industries", path = "industries")
public interface IndustrySizeRepository extends PagingAndSortingRepository<IndustrySize, Long> {

    IndustrySize findByTitle(@Param("name") String title);

    Collection<IndustrySize> findByTitleLike(@Param("title") String title);

    // @Query("MATCH (n:Organization)-[s:SURGING_ON]->(t:Topic) WHERE t.name = \"Graph Databases\" and s.weight>80  RETURN n,s,t  LIMIT {limit}")

    @Query("MATCH (n:IndustrySize)-[:ORG_SIZED_AS]->(o:Organization) where n.name = 'Small (10 - 49 Employees)' RETURN n LIMIT {limit}")
    Collection<IndustrySize> grapher(@Param("limit") int limit);
}

