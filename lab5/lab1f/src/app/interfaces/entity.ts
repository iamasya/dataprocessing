export interface Entity {
    id: number;
    title: string;
    info: string;
    price: number;
    _links:{
        self: {
            href: string;
        },
        flower: {
            href: string;
        }
    }
}