import { Injectable } from '@angular/core'
import { Response, Http, Headers } from '@angular/http';
import 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';
@Injectable()
export class ServerService{
constructor(private http:Http){}
storeUsers ( users: any[]) {
    const headers = new Headers({'Content-Type': 'application/json'});
return this.http.post("http://localhost:8080/BackendApp/user/", users,{headers:headers})


}
}