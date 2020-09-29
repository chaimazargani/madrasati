import { Eleve } from "./eleve";
import { Matier } from "./matier";
import { Classe } from "./classe";
import { Utilisateur } from "./utilisateur";

export class EleveNoteDTO {
    public nomEleve: string; 
    public valeurNote: number;
    public nomExamen : string ;
    public idExamen : number ; 
    public idEleve : number ; 
    public idMatier : number ; 
}