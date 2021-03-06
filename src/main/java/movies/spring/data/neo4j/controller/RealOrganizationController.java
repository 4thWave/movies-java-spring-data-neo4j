package movies.spring.data.neo4j.controller;


import java.util.Map;

import movies.spring.data.neo4j.services.RealOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import movies.spring.data.neo4j.domain.RealOrganization;
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
@RestController("/realorgan")
public class RealOrganizationController {

    final RealOrganizationService realOrganizationService;

    @Autowired
    public RealOrganizationController(RealOrganizationService realOrganizationService) {
        this.realOrganizationService = realOrganizationService;
    }

    @RequestMapping("/grapher")
    public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
        return realOrganizationService.graph(limit == null ? 100 : limit);
    }
   
        
        
    @RequestMapping(value = "/realorg", method = RequestMethod.POST)
public ResponseEntity<RealOrganization> update(@RequestBody RealOrganization org) {

    if (org != null) {
         System.out.println(org.getPrimaryName());
        org.setPrimaryName(org.getPrimaryName());
    }
   
    // TODO: call persistence layer to update
    return new ResponseEntity<RealOrganization>(org, HttpStatus.OK);
}
}
