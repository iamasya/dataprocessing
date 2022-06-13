export interface Instrument {
        id:number;
        title:string;
        info:string;
        price:number;
        _links:{
        
                self: {
                        href: string;
                },
                instrument: {
                        href: string;
                }
        }
}

