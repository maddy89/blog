import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-servers',
  templateUrl: './servers.component.html',
  styleUrls: ['./servers.component.css']
})
export class ServersComponent implements OnInit {
  allowNew = false;
  serverCreationStatus = 'No server was created';
  serverName = 'Test_server';

  constructor() { 
    setTimeout(() => { //after 3 seconds set to false
      this.allowNew = true;
    },3000);
  }

  ngOnInit() {
  }

  onCreateServer () {
    this.serverCreationStatus = 'Server ' + this.serverName + ' was created!';
  }
  onUpdateServerName (event : Event) {
    this.serverName = (<HTMLInputElement>event.target).value; //we explicitely cast(<>) this to inform TS that the type of html element of this event is html input element
  }

}
