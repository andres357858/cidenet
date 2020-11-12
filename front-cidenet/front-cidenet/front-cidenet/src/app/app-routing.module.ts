import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaEmpleadoComponent } from './empleado/lista-empleado.component';
import { DetalleEmpleadoComponent } from './empleado/detalle-empleado.component';
import { NuevoEmpleadoComponent } from './empleado/nuevo-empleado.component';
import { EditarEmpleadoComponent } from './empleado/editar-empleado.component';


const routes: Routes = [
  {path: '', component: ListaEmpleadoComponent},
  {path: 'detalle/:id', component: DetalleEmpleadoComponent},
  {path: 'nuevo', component: NuevoEmpleadoComponent},
  {path: 'editar/:id', component: EditarEmpleadoComponent},
  {path: '**', redirectTo: '', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
