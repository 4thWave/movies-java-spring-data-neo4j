package movies.spring.data.neo4j.controller;


import java.util.Map;

import movies.spring.data.neo4j.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import movies.spring.data.neo4j.domain.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
   
        
        
    @RequestMapping(value = "/org", method = RequestMethod.POST)
public ResponseEntity<Organization> update(@RequestBody Organization org) {

    if (org != null) {
         System.out.println(org.getName());
        org.setName(org.getName());
    }
   
    // TODO: call persistence layer to update
    return new ResponseEntity<Organization>(org, HttpStatus.OK);
}
}
