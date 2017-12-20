package movies.spring.data.neo4j.repositories;


import static org.junit.Assert.*;

import java.util.Collection;

import movies.spring.data.neo4j.domain.Organization;
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
public class OrganizationRepositoryTest {

    @Autowired
    private Session session;

    @Autowired
    private OrganizationRepository instance;

    @Autowired
    private TopicRepository topicRepository;

    public OrganizationRepositoryTest() {
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

        String title = "Media Services";
        Organization result = instance.findByTitle(title);
        assertNotNull(result);
       // assertEquals(1999, result.getReleased());
    }



    /**
     * Test of graph method, of class MovieRepository.
     */
    @Test
    public void testGraph() {
        Collection<Organization> graph = instance.graph(5);
        System.out.println("The graph is "+ graph.size());
        assertEquals(5, graph.size());

        Organization org = graph.iterator().next();

        assertEquals("Media Services", org.getName());

      //  assertEquals("Keanu Reeves", movie.getRoles().iterator().next().getPerson().getName());
    }
}
