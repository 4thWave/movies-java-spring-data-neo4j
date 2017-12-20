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
@RelationshipEntity(type = "ORG_SIZED_AS")
public class Size {

    @GraphId
    private Long id;

    private Collection<String> sizes = new ArrayList<>();

    @StartNode
    private IndustrySize isize;

    @EndNode
    private Organization organization;

    public Size() {
    }

    public Size(Organization organization, IndustrySize isize) {
        this.organization = organization;
        this.isize = isize;
    }

    public Long getId() {
        return id;
    }

    public Collection<String> getSizes() {
        return sizes;
    }

    public Organization getOrganization() {
        return organization;
    }

    public IndustrySize getIndustrySize() {
        return isize;
    }

    public void addSizeName(String name) {
        this.sizes.add(name);
    }
}
