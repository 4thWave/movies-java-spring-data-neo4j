package movies.spring.data.neo4j.services;


import java.util.*;

import movies.spring.data.neo4j.domain.RealOrganization;
import movies.spring.data.neo4j.domain.Score;
import movies.spring.data.neo4j.repositories.RealOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RealOrganizationService {

    @Autowired RealOrganizationRepository realOrganizationRepository;

    private Map<String, Object> toD3Format(Collection<RealOrganization> organizations) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<RealOrganization> result = organizations.iterator();
        while (result.hasNext()) {
            RealOrganization organization = result.next();
            nodes.add(map("title", organization.getPrimaryName(), "label", "movie"));
            int target = i;
             
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
        Collection<RealOrganization> result = realOrganizationRepository.graph(limit);
        return toD3Format(result);
    }
}
