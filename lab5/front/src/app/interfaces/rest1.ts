import { Instrument } from "./instrument"

export interface Rest1 {
    _embedded: {
        instruments: Instrument[]
        },
        _links: {
        self: {
        href: string;
        },
        profile: {
        href: string;
        }
        },
        page: {
        size: number,
        totalElements: number,
        totalPages: number,
        number: number
        }

}
