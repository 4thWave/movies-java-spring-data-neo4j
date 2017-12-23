package movies.spring.data.neo4j.services;

public interface ImportService {

    void clearDatabase();

    void load();
}
