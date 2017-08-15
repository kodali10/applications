import { Component, ElementRef, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';
import { Response, Http, Headers } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { ServerService } from './server.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  user = [{name: "Bose",age: 25, email: "rkodali10@gmail.com"}];
  user1 = {

	"name" : "Paris",
	"age" : 23,
	"email": "paris@gmail.com"
};
  constructor(private http: Http, private serverService: ServerService){

  }

  ngOnInit(){
    this.fetchData().then(r => this.user =r);

  }

  onSave(){
  var headers = new Headers();
  headers.append('Content-Type', 'application/json');
  return this.http.post(
    'http://localhost:8080/BackendApp/user/new',
    JSON.stringify(this.user1), {
      headers: headers
    }).toPromise().then((response) => console.log(response),
    (error) => console.log(error));
}
    //const headers = new Headers({'Content-Type': 'application/json'});
//return this.http.post("http://localhost:8080/BackendApp/user/new", JSON.stringify(this.user),{headers:headers})
//.toPromise();


    //this.serverService.storeUsers(this.user)
    //.toPromise()
    //.then(r => r.json());
    //.subscribe(
      //(response) => console.log(response),
      //(error) => console.log(error)
    //);
  //}
fetchData(){
  return this.http.get("http://localhost:8080/BackendApp/users/")
    .toPromise()
    .then(r => r.json());


}


}
