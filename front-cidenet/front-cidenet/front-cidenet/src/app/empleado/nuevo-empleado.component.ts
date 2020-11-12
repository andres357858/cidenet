import { Component, OnInit } from '@angular/core';
import { EmpleadoService } from '../service/empleado.service';
import { Empleado } from '../models/empleado';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo-empleado',
  templateUrl: './nuevo-empleado.component.html',
  styleUrls: ['./nuevo-empleado.component.css']
})
export class NuevoEmpleadoComponent implements OnInit {

  primerApellido :string;
  segundoApellido :string;
  primerNombre :string;
  otroNombre :string;
  pais :string;
  tipoIdentificacion :string;
  numIdentificacion :string;
  fechaIngreso: Date;
  area: string;
  lista_pais:string[]=["COLOMBIA","ESTADOS_UNIDOS"];
  tipo_id:string[]=["Cédula de Ciudadanía", "Cédula de Extranjería", "Pasaporte", "Permiso Especial"];
  lista_area:string[]=["Administración", "Financiera", "Compras", "Infraestructura", "Operación", 
  "Talento Humano", "Servicios Varios"];
  date = new Date();
  dd = this.date.getDate();
  mm = this.date.getMonth()+1; 
  yyyy = this.date.getFullYear();
  today = this.yyyy+'-'+this.mm+'-'+this.dd;

  constructor(
    private empleadoService: EmpleadoService,
    private toastr: ToastrService,
    private router: Router
    ) { }

  ngOnInit() {
  
  }

  onCreate(): void {
    const empleado = new Empleado(this.primerApellido, this.segundoApellido,
    this.primerNombre, this.otroNombre,this.pais,
    this.tipoIdentificacion,this.numIdentificacion,this.fechaIngreso,this.area);
    this.empleadoService.save(empleado).subscribe(
      data => {
        this.toastr.success('Empleado Creado', 'OK', {
          timeOut: 3000, positionClass: 'toast-top-center'
        });
        this.router.navigate(['/']);
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/']);
      }
    );
  }

}
