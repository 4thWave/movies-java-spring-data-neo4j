package movies.spring.data.neo4j.domain;


import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author C Gaines
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@RelationshipEntity(type = "SURGING_ON")
public class Score {

    @GraphId
    private Long id;

    private Collection<String> scores = new ArrayList<>();

    @StartNode
    private Topic topic;

    @EndNode
    private Organization organization;

    public Score() {
    }

    public Score(Organization organization, Topic topic) {
        this.organization = organization;
        this.topic = topic;
    }

    public Long getId() {
        return id;
    }

    public Collection<String> getScores() {
        return scores;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Topic getTopic() {
        return topic;
    }

    public void addScoreName(String name) {
        this.scores.add(name);
    }
}
