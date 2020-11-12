import { Component, OnInit } from '@angular/core';
import { Empleado } from '../models/empleado';
import { EmpleadoService } from '../service/empleado.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-lista-empleado',
  templateUrl: './lista-empleado.component.html',
  styleUrls: ['./lista-empleado.component.css']
})
export class ListaEmpleadoComponent implements OnInit {

  empleados: Empleado[] = [];
  page = 1;


  constructor(
    private empleadoService: EmpleadoService,
    private toastr: ToastrService
    ) { }

  ngOnInit() {
    this.cargarEmpleados();
  }

  cargarEmpleados(): void {
    this.empleadoService.lista().subscribe(
      data => {
        this.empleados = data;
      },
      err => {
        console.log(err);
      }
    );
  }

  borrar(id: number) {
    if (confirm('Está seguro de que desea eliminar el empleado?')){
      this.empleadoService.delete(id).subscribe(
        data => {
          this.toastr.success('Empleado Eliminado', 'OK', {
            timeOut: 3000, positionClass: 'toast-top-center'
          });
          this.cargarEmpleados();
        },
        err => {
          this.toastr.error(err.error.mensaje, 'Fail', {
            timeOut: 3000,  positionClass: 'toast-top-center',
          });
        }
      );
   }

  }

}
