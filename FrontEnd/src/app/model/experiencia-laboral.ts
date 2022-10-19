export class ExperienciaLaboral {
    id?: number;
    nombreExpLab: string;
    descripcionExpLab: string;

    constructor(nombreExpLab: string, descripcionExpLab: string){
        this.nombreExpLab = nombreExpLab;
        this.descripcionExpLab = descripcionExpLab;
    }
}
