MATCH (ou:Organization {name : 'STOCK WESTCON GROUP EUROPEAN OPERATIONS LTD'})
MERGE (ou)-[:CONNECTS_TO_SITE]->(bsiteo:BestSiteOrg {name : 'STOCK WESTCON GROUP EUROPEAN OPERATIONS LTD'})


 MERGE (o1:Organization {name : 'Michael R Coker Co', domain : 'cokercompany.com'})  
 MERGE (o1)-[:RELATES_TO_DOMAIN]->(domain:Domain {name : 'cokercompany.com'})


 MATCH (n:Domain) RETURN n LIMIT 25

 