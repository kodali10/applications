import {Component, OnInit} from '@angular/core';
import * as firebase from 'firebase';
import {DomSanitizer} from "@angular/platform-browser";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  loadedFeature = 'recipe';

  imgPath;

  constructor(private sanitizer: DomSanitizer) {
    this.imgPath = sanitizer.bypassSecurityTrustStyle('url(' +
      'http://www.foodwise.com.au/wp-content/themes/foodwise/images/bg-6.jpg' +
      ')');
  }

  ngOnInit() {
    firebase.initializeApp({
      apiKey: "AIzaSyBKSkhiiU_TQGSqlLpfn5lXkYjgnrepDwA",
      authDomain: "ng-recipe-book-b7009.firebaseapp.com"
    });
  }

  onNavigate(feature: string) {
    this.loadedFeature = feature;
  }
}
