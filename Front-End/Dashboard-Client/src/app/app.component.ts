import {Component, Input} from '@angular/core';
import {BrowserModule, DomSanitizer} from '@angular/platform-browser';
import {ToggleService} from './toggle.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ToggleService]
})
export class AppComponent {
  loadPage = 'home';
  imgPath;

  constructor(private sanitizer: DomSanitizer, private togglepage: ToggleService) {
    this.imgPath = sanitizer.bypassSecurityTrustStyle('url(http://www.hdwallpapers.in/download/macos_high_sierra_stock_5k-1280x720.jpg)');
  }
  onLoadPage(page: string) {
    this.loadPage = page;
  }


}
