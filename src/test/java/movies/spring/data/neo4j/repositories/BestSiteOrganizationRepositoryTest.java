package movies.spring.data.neo4j.repositories;


import static org.junit.Assert.*;

import java.util.Collection;

import movies.spring.data.neo4j.domain.IndustrySize;
import movies.spring.data.neo4j.domain.BestSiteOrganization;
import movies.spring.data.neo4j.domain.Topic;
import movies.spring.data.neo4j.domain.Score;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author cgaine
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
public class BestSiteOrganizationRepositoryTest {

    @Autowired
    private Session session;

    @Autowired
    private BestSiteOrganizationRepository instance;



    public BestSiteOrganizationRepositoryTest() {
    }

    @Before
    public void setUp() {
        //   Organization portalco = new Organization("The Portalco", 1999);

        //  instance.save(portalco);

//
//
        //   Score neo = new Score(portalco, graphtop);
        //   neo.addScoreName("92");

//
        //  instance.save(portalco);
    }

    @After
    public void tearDown() {

        //session.purgeDatabase();
    }

    /**
     * Test of findByTitle method, of class MovieRepository.
     */
    @Test
    public void testFindByTitle() {

        String title = "Lauren James Co";
        BestSiteOrganization result = instance.findByTitle(title);
        assertNotNull(result);
        // assertEquals(1999, result.getReleased());
    }



    /**
     * Test of graph method, of class MovieRepository.
     */
    @Test
    public void testGraph() {
        Collection<BestSiteOrganization> graph = instance.graphorg(5);
        System.out.println("The graph is "+ graph.size());
        assertEquals(2, graph.size());


        //  assertEquals("Keanu Reeves", movie.getRoles().iterator().next().getPerson().getName());
    }
}
