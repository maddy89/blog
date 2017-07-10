import { Component } from '@angular/core'; //import component from angular core

@Component({ //decorator. enhances the class. configures with given meta data
    selector: 'app-server', //unique selector
    templateUrl: './server.component.html' // where to find the template  
})
export class ServerComponent {
    serverId: number = 10;
    serverStatus: string = 'offline';

    getServerStatus() {
        return this.serverStatus;
    }

}