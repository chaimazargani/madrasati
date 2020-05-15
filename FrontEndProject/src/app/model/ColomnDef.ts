import { Children } from "./Children";
import { CellEditorParams } from "./cellEditorParams";

export class ColomnDef {

public headerName  : string ;
public marryChildren : boolean ;
public children : Children [];
public field1 : string ;
public  cellRenderer : string ;
public cellEditor : string  ;
public  cellEditorParams :  CellEditorParams [] ;
constructor(){

}

}