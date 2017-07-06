Angular Basics
==============

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

Modules:
* Bundles smaller pieces like components into packages

