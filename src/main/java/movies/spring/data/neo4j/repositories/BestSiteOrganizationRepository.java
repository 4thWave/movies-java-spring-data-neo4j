package movies.spring.data.neo4j.repositories;


import java.util.Collection;

import movies.spring.data.neo4j.domain.BestSiteOrganization;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author Michael Hunger
 * @author Mark Angrish
 */
@RepositoryRestResource(collectionResourceRel = "bestsiteorganizations", path = "bestsiteorganizations")
public interface BestSiteOrganizationRepository extends PagingAndSortingRepository<BestSiteOrganization, Long> {

    BestSiteOrganization findByTitle(@Param("name") String title);

    Collection<BestSiteOrganization> findByTitleLike(@Param("title") String title);

    // @Query("MATCH (n:Organization)-[s:SURGING_ON]->(t:Topic) WHERE t.name = \"Graph Databases\" and s.weight>80  RETURN n,s,t  LIMIT {limit}")

    @Query("MATCH (n:Organization)-[:SITED_IN]->(o:BestSiteOrganization)   RETURN n,o, LIMIT {limit}")
    Collection<BestSiteOrganization> graphorg(@Param("limit") int limit);
}

