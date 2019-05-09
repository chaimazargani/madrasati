import { Eleve } from "./eleve";
import { Matier } from "./matier";
import { Classe } from "./classe";
import { Utilisateur } from "./utilisateur";

export class EleveNoteDTO {
    public idNote: number ;
    public nomNote: number; 
    public valeurNote: number;
   public eleve: Eleve;
   public matier: Matier;
   public  idEleve: number;
   public  classe: Classe;
   public  utilisateur: Utilisateur;
}