import {Component, EventEmitter, OnInit, Output} from '@angular/core';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  logoPath = 'http://dashboard.net/wp-content/uploads/2016/08/Dashboard-R-Logo-header.png';
  @Output() selected = new EventEmitter<string>();
  ngOnInit() {
  }

  selectedFeature(page: string) {
    this.selected.emit(page);
  }
}
