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
public class IndustrySize {

    @GraphId
    private Long id;

    private String name;
    private String title;

    @Relationship(type = "ORG_SIZED_AS", direction = Relationship.INCOMING)
    private List<IndustrySize> sizes = new ArrayList<>();

    public IndustrySize() {
    }

    public IndustrySize(String name) {

        this.name = name;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Collection<IndustrySize> getSizes() {
        return sizes;
    }

    public void addSize(IndustrySize size) {
        this.sizes.add(size);
    }
}
