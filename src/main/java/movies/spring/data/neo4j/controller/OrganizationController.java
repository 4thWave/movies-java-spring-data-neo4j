package movies.spring.data.neo4j.controller;


import java.util.Map;

import movies.spring.data.neo4j.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mark Angrish
 */
@RestController("/rc")
public class OrganizationController {

    final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping("/graphy")
    public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
        return organizationService.graph(limit == null ? 100 : limit);
    }
}
