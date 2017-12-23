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
 * @author C Gaines
 */
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@NodeEntity
public class BestSiteOrganization {

    @GraphId
    private Long id;

    private String title;
    private String address1;
    private String address2;
    private String city;
    private String state;
    private String postalcode;
    private String country;
    private String theater;

    @Relationship(type = "SITED_ID", direction = Relationship.INCOMING)
    private List<Organization> organizations = new ArrayList<>();


    private int released;

    private String tagline;

    public Long getPartyid() {
        return partyid;
    }

    public void setPartyid(Long partyid) {
        this.partyid = partyid;
    }

    private Long partyid;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }




    public BestSiteOrganization() {
    }

    public BestSiteOrganization(String title, int released) {

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

    public int getReleased() {
        return released;
    }

    public String getTagline() {
        return tagline;
    }

    public Collection<Organization> getOrganizations() {
        return organizations;
    }

    public void addOrganization(Organization organization) {
        this.organizations.add(organization);
    }
}
