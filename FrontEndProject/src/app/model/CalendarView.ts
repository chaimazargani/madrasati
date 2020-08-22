import { Subject } from "rxjs";

export class CalendarView {
    public view: CalendarView ;
   public viewDate: Date ;
   public viewDays: number; 
   public refresh: Subject<any>; 
   public locale: string ;
   public hourSegments: number ;
   public weekStartsOn: number ;
   public startsWithToday: boolean ;
   public activeDayIsOpen: boolean ;
   public excludeDays: number[] ;
   public  weekendDays: number[] ;
   public dayStartHour: number;
   public dayEndHour: number ;
    public minDate: Date ;
   public maxDate: Date ;
   public dayModifier
   public hourModifier;
   public segmentModifier;
   public prevBtnDisabled;
    public nextBtnDisabled ;
    static Week: CalendarView;




    constructor() {
        
    }
}