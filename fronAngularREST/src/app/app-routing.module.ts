import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListaEmpleadosComponent } from './lista-empleados/lista-empleados.component';
import { NuevoEmpleadoComponent } from './nuevo-empleado/nuevo-empleado.component';
import { ActualizarEmpleadoComponent } from './actualizar-empleado/actualizar-empleado.component';

const routes: Routes = [
  {path:'empleado', component:ListaEmpleadosComponent},
  {path:'',redirectTo:'empleado',pathMatch:'full'},
  {path:'nuevo-empleado', component:NuevoEmpleadoComponent},
  {path:'actualizar-empleado/:id', component:ActualizarEmpleadoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
