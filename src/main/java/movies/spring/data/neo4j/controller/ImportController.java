package movies.spring.data.neo4j.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movies.spring.data.neo4j.services.ImportService;

@RestController
public class ImportController {

    private ImportService service;

    @Autowired
    public ImportController(ImportService service) {
        this.service = service;
    }


    @Transactional
    @RequestMapping("/api/reload")
    public ResponseEntity reload() {
        System.out.println("api reload");
       // service.clearDatabase();
        service.myload();

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

}
