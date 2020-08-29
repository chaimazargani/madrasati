import { Classe } from './classe';
import { Matier } from './matier';
import { Enseignant } from './Enseignant';

export class MatierEnseignantClasse {
    public matier: Matier;
    public enseignant: Enseignant;
    public classe: Classe; 
     public nomMatier : string ;
      public constructor () {
      }
}