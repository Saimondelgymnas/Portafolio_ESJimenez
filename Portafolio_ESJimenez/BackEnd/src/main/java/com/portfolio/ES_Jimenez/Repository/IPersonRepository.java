
package com.portfolio.ES_Jimenez.Repository;

import com.portfolio.ES_Jimenez.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IPersonRepository extends JpaRepository<Person,Long> {
    
}
