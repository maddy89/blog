import { Component } from '@angular/core';

@Component({
  selector: 'app-root', //replace which part of index.html
  templateUrl: './app.component.html', //external html template
  styleUrls: ['./app.component.css'] //array of style sheets to be applied
})
export class AppComponent {
  title = 'app';
  name = 'Madhawa';
}