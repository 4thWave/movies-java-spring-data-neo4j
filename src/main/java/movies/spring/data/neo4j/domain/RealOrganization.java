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
public class RealOrganization {

    @GraphId
    private Long id;

    private String primaryStreetAddress1;
    private String primaryStreetAddress2;
    private String primaryCity;
    private String primaryState;
    private String primaryZip;
     private String domain;
    private int founded;

    private String tagline;
    private String primaryName;
    private String tradeName;

    
    @Relationship(type = "ORG_SIZED_AS", direction = Relationship.OUTGOING)
    private List<IndustrySize> sizes = new ArrayList<>();


    public String getPrimaryStreetAddress1() {
        return primaryStreetAddress1;
    }

    public void setPrimaryStreetAddress1(String primaryStreetAddress1) {
        this.primaryStreetAddress1 = primaryStreetAddress1;
    }

    public String getPrimaryStreetAddress2() {
        return primaryStreetAddress2;
    }

    public void setPrimaryStreetAddress2(String primaryStreetAddress2) {
        this.primaryStreetAddress2 = primaryStreetAddress2;
    }

    public String getPrimaryCity() {
        return primaryCity;
    }

    public void setPrimaryCity(String primaryCity) {
        this.primaryCity = primaryCity;
    }

    public String getPrimaryState() {
        return primaryState;
    }

    public void setPrimaryState(String primaryState) {
        this.primaryState = primaryState;
    }

    public String getPrimaryZip() {
        return primaryZip;
    }

    public void setPrimaryZip(String primaryZip) {
        this.primaryZip = primaryZip;
    }

    public int getFounded() {
        return founded;
    }

    public void setFounded(int founded) {
        this.founded = founded;
    }

    public String getPrimaryName() {
        return primaryName;
    }

    public void setPrimaryName(String primaryName) {
        this.primaryName = primaryName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public List<IndustrySize> getSizes() {
        return sizes;
    }

    public void setSizes(List<IndustrySize> sizes) {
        this.sizes = sizes;
    }
    
   
    public RealOrganization() {
    }

    public RealOrganization(String primaryName,int founded) {

        this.primaryName = primaryName;
        this.founded = founded;
    }

     public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

     

    public String getTagline() {
        return tagline;
    }

    public Collection<IndustrySize> getIndustrySizes() {
        return sizes;
    }


    public void addIndustrySize(IndustrySize size) {
        this.sizes.add(size);
    }
}
