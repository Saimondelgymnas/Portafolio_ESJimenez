import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { person } from '../model/person.model';

@Injectable({
  providedIn: 'root'
})
export class PersonService {
  URL = 'https://backdend-esjimenez.herokuapp.com/persons/';

  constructor(private http: HttpClient) { }

public getPerson(): Observable<person>{
  return this.http.get<person>(this.URL+'traer/perfil');
}  

}
