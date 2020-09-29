import { Injectable } from '@angular/core';
import { MessageService } from 'primeng/api';

@Injectable({
    providedIn: 'root',
})
export class ToastUtils {

    constructor(private messageService:MessageService){}
    public showSuccess(summary?,details?) {
        this.messageService.add({severity:'success', summary: summary, detail:details});
      }
    
    public showError(summary?,details?) {
      this.messageService.add({severity:'error', summary: summary, detail:details});
    }
}
