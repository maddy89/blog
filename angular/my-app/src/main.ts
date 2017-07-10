// this is the entry point of execution
import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule); 
/*
Execution Order
1. main.ts gets excuted first
2. boostrap app.module.ts (is to be loaded first)
3. analyze app component upon start
4. selector tells to look for <app-root></app-root> in index.html
5. insert app component(app.component.html) into <app-root>
*/
