import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ServerComponent } from './server/server.component';
import { ServersComponent } from './servers/servers.component'

@NgModule({
  declarations: [ //registers the components
    AppComponent,
    ServerComponent,
    ServersComponent
  ],
  imports: [ //adds other modules
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent] // components to be loaded at start 
})
export class AppModule { }
