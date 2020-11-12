export class Empleado {
    id?: number;
    primerApellido :string;
    segundoApellido :string;
    primerNombre :string;
    otroNombre :string;
    pais :string;
    tipoIdentificacion :string;
    numIdentificacion :string;
    correo? : string;
    fechaIngreso: Date;
    area: string;
    estado? : string;
    fechaRegistro? : Date;


    constructor(primerApellido :string,
        segundoApellido :string,
        primerNombre :string,
        otroNombre :string,
        pais :string,
        tipoIdentificacion :string,
        numIdentificacion :string, fechaIngreso: Date,
        area: string) {

        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.primerNombre = primerNombre;
        this.otroNombre = otroNombre;
        this.pais = pais;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numIdentificacion = numIdentificacion;
        this.fechaIngreso = fechaIngreso;
        this.area = area;
    }
}


