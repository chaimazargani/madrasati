export class AppareilService {
   appareils = [
      {
        name :  'machine a laver' ,
         etat : 'allumer',
       },
        {
      name : 'portable' ,
       etat : 'allumer',
      },
    
     {
       name: 'television' ,
       etat : 'eteint' ,
      },
     ];
    

     switchOnAll() {
        for (let appareil of this.appareils){
            appareil.etat ='allumer'  

          }
      }
      switchOffAll() {
          for(let appareil of this.appareils) {
             appareil.etat = 'eteint' 
          }
         }
      switchOnOne (index : number) {
        this.appareils[index].etat ='allumer'
      }
        switchOffOne(index : number){
        this.appareils[index].etat= 'eteint'
      }
   }