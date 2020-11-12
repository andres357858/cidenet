import { Component, OnInit } from '@angular/core';
import { Empleado } from '../models/empleado';
import { EmpleadoService } from '../service/empleado.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-editar-empleado',
  templateUrl: './editar-empleado.component.html',
  styleUrls: ['./editar-empleado.component.css']
})
export class EditarEmpleadoComponent implements OnInit {

  empleado: Empleado = null;
  date = new Date();
  dd = this.date.getDate();
  mm = this.date.getMonth()+1; 
  yyyy = this.date.getFullYear();
  today = this.yyyy+'-'+this.mm+'-'+this.dd;
  lista_pais:string[]=["COLOMBIA","ESTADOS_UNIDOS"];
  tipo_id:string[]=["Cédula de Ciudadanía", "Cédula de Extranjería", "Pasaporte", "Permiso Especial"];
  lista_area:string[]=["Administración", "Financiera", "Compras", "Infraestructura", "Operación", 
  "Talento Humano", "Servicios Varios"];

  constructor(
    private empleadoService: EmpleadoService,
    private activatedRoute: ActivatedRoute,
    private toastr: ToastrService,
    private router: Router
  ) { }

  ngOnInit() {
    const id = this.activatedRoute.snapshot.params.id;
    this.empleadoService.detail(id).subscribe(
      data => {
        this.empleado = data;
      },
      err => {
        this.toastr.error(err.error.mensaje, 'Fail', {
          timeOut: 3000,  positionClass: 'toast-top-center',
        });
        this.router.navigate(['/']);
      }
    );
  }

  onUpdate(): void {
    const id = this.activatedRoute.snapshot.params.id;
    this.empleadoService.update(id, this.empleado).subscribe(
      data => {
        this.toastr.success('Empleado Actualizado', 'OK', {
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
