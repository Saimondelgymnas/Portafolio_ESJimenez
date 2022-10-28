
package com.portfolio.ES_Jimenez.Interface;

import com.portfolio.ES_Jimenez.Entity.Person;
import java.util.List;


public interface IPersonService {
    public List<Person> getPerson();
            
    public void savePerson(Person person);
    
    public void deletePerson (Long id);
    
    public Person findPerson(Long id);
}
