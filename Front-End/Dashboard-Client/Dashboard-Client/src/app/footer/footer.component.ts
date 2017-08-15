import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  logoPath = 'http://dashboard.net/wp-content/uploads/2016/08/Dashboard-R-Logo-header.png';
  constructor() { }

  ngOnInit() {
  }

}
