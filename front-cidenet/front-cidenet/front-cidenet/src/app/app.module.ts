import { BrowserModule } from '@angular/platform-browser';
import { NgModule,CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListaEmpleadoComponent } from './empleado/lista-empleado.component';
import { DetalleEmpleadoComponent } from './empleado/detalle-empleado.component';
import { NuevoEmpleadoComponent } from './empleado/nuevo-empleado.component';
import { EditarEmpleadoComponent } from './empleado/editar-empleado.component';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';

// external
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';


@NgModule({
  declarations: [
    AppComponent,
    ListaEmpleadoComponent,
    DetalleEmpleadoComponent,
    NuevoEmpleadoComponent,
    EditarEmpleadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class AppModule { }
