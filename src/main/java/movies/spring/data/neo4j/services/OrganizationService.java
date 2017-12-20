package movies.spring.data.neo4j.services;


import java.util.*;

import movies.spring.data.neo4j.domain.Organization;
import movies.spring.data.neo4j.domain.Score;
import movies.spring.data.neo4j.repositories.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrganizationService {

    @Autowired OrganizationRepository organizationRepository;

    private Map<String, Object> toD3Format(Collection<Organization> organizations) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<Organization> result = organizations.iterator();
        while (result.hasNext()) {
            Organization organization = result.next();
            nodes.add(map("title", organization.getTitle(), "label", "movie"));
            int target = i;
            i++;
            for (Score score : organization.getScores()) {
                Map<String, Object> topic = map("title", score.getTopic().getName(), "label", "actor");
                int source = nodes.indexOf(topic);
                if (source == -1) {
                    nodes.add(topic);
                    source = i++;
                }
                rels.add(map("source", source, "target", target));
            }
        }
        return map("nodes", nodes, "links", rels);
    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

    @Transactional(readOnly = true)
    public Map<String, Object>  graph(int limit) {
        Collection<Organization> result = organizationRepository.graph(limit);
        return toD3Format(result);
    }
}
