+-+-+-+-+-+-+-+-+
| Angular Notes |
+-+-+-+-+-+-+-+-+

1. Basics
=========

Intro:
* Based on TypeScript - typed javascrpt with more functionality like classes, interfaces
* Uses Webpack for bundling/packaging
* When bundling the app, Angular will add the necessary <script></script> tags to index.html.
* First to execute is main.ts


Execution Order:
1. main.ts gets excuted first
2. boostrap app.module.ts (is to be loaded first)
3. analyze app component upon start
4. selector tells to look for <app-root></app-root> in index.html
5. insert app component(app.component.html) into <app-root>


Decorators:
* Enhances the functinality of classes/methods
* Has @ at the begning of the decorator


Components:
* Angular apps are made of a set of components
* Has its own business logi and html
* Allows complex apps to be broken into reusable parts
* App component is the root component.
* Selectors of other custom components should NOT be in index.html, but in the app.component.html file

* A selector can be
'app-server' - by element -> <app-server>
['app-server'] - by attribute -> <div app-server>
.'app-server' - by class -> <div class="app-server">

e.g.
@Component({ //decorator. enhances the class. configures with given meta data
    selector: 'app-selector', //unique selector
    template: './server.compoenent.html' // where to find the template  
})
export class ServerComponent {
}


Modules:
* Bundles smaller pieces like components into packages

e.g.
@NgModule({ //decorator
  declarations: [ //registers the components
    AppComponent
  ],
  imports: [ //adds other modules
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent] // components to be loaded at start 
})


Adding a component:
1. create component x that includes x.component.html and x.component.ts

@Component({
  selector: 'x-servers',
  templateUrl: './x.component.html',
  styleUrls: ['./x.component.css']
})

2. import into app module
import { XComponent } from './x/x.component'
3. declare in the app module
declarations: [ //registers the components
    AppComponent,
    XComponent
  ],
4. add selector to app component html
<app-x></app-x>


2. Data Binding
================
                      output
            |        --------->                         |
            |    String Interpolation {{ data }}        |
            |                                           |
            |                                           |
            |        --------->                         |
            |    Property Binding [property]="data"     |
    TS Code |                                           |  Template 
(Bussiness  |                                           | (Presentation)
 logic)     |          input                            |
            |        <---------                         |
            |    Event Binding (event)="expression"     |
            |                                           |
            |                                           |
            |          both                             |
            |        <--------->                        |
            |    Two-way binding [(ngModel)]="data"     |
            |                                           |
            |                                           |
                        
String Interpolation: - when we need to output something in text
<p>Server with ID: {{ serverId }} is {{ serverStatus }}</p>

Property Binding: - when we want to change html properties, directives
<button class="btn btn-primary" [disabled]="!allowNew">Add Server</button>

Event Binding: - when binding events to model
<button 
  class="btn btn-primary" [disabled]="!allowNew"
  (click) = "onCreateServer()">
  Add Server</button>


3. Directives
=============
