package movies.spring.data.neo4j.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * @author Mark Angrish
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class Organization {

    @GraphId
    private Long id;

    private String title;

    private int released;

    private String tagline;
    private String name;

    @Relationship(type = "SURGING_FOR", direction = Relationship.OUTGOING)
    private List<Score> scores = new ArrayList<>();

    @Relationship(type = "ORG_SIZED_AS", direction = Relationship.OUTGOING)
    private List<IndustrySize> sizes = new ArrayList<>();

    public Organization() {
    }

    public Organization(String title, int released) {

        this.title = title;
        this.released = released;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    public int getReleased() {
        return released;
    }

    public String getTagline() {
        return tagline;
    }

    public Collection<IndustrySize> getIndustrySizes() {
        return sizes;
    }

    public Collection<Score> getScores() {
        return scores;
    }

    public void addIndustrySize(IndustrySize size) {
        this.sizes.add(size);
    }
}
