import {Component, Input, OnInit} from '@angular/core';
import {Headers, Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {ServerServiceService} from '../server-service.service';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  logoPath = 'http://dashboard.net/wp-content/uploads/2016/08/Dashboard-R-Logo-header.png';
  @Input() whichPage;
  name = '';
  email = '';
  password = '';


  constructor(private http: Http, private serverService: ServerServiceService) {

  }

  ngOnInit() {
  }

  loginToggle(page: string) {

    this.whichPage = page;
    console.log(this.whichPage);
  }

  onSignin() {
    const userSignin = {'name': this.name, 'password': this.password};
    this.name = '';
    this.email = '';
    this.password = '';
    console.log(userSignin);
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post(
      'http://localhost:8080/Dashboard-Server/user/new',
      JSON.stringify(userSignin), {
        headers: headers
      }).toPromise().then((response) => console.log(response),
      (error) => console.log(error));

  }

  onSignup() {
    const userSignup = {
      'name': this.name, 'email': this.email,
      'password': this.password
    };
    console.log(userSignup);
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post(
      'http://localhost:8080/Dashboard-Server/user/new',
      JSON.stringify(userSignup), {
        headers: headers
      }).toPromise().then((response) => console.log(response),
      (error) => console.log(error));
  }
}
