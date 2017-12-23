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
@RelationshipEntity(type = "SITED_IN")
public class Sited {

    @GraphId
    private Long id;

    private Collection<String> organizations = new ArrayList<>();

    @StartNode
    private BestSiteOrganization bestsiteorganization;

    @EndNode
    private Organization organization;

    public Sited() {
    }

    public Sited(Organization organization, BestSiteOrganization bestsiteorganization) {
        this.organization = organization;
        this.bestsiteorganization = bestsiteorganization;
    }

    public Long getId() {
        return id;
    }

    public Collection<String> getOrganizations() {
        return organizations;
    }

    public Organization getOrganization() {
        return organization;
    }



    public void addOrganizations(String name) {
        this.organizations.add(name);
    }
}
