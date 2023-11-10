import swal from 'sweetalert2';
import { Component, OnInit } from '@angular/core';
import { Empelado } from '../Empleado';
import { EmpleadoService } from '../empleado.service';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-lista-empleados',
  templateUrl: './lista-empleados.component.html',
  styleUrls: ['./lista-empleados.component.css']
})
export class ListaEmpleadosComponent implements OnInit {

  empleado!:Empelado[];

  constructor(private empleadoService:EmpleadoService, private route:Router) { }

  ngOnInit(): void {
    this.obtenerEmpleado();
  }

  private obtenerEmpleado(){
    this.empleadoService.obtenerListaEmpleados().subscribe(dato =>{
      this.empleado = dato;
    });
  }

  actualizarEmpleado(id:number){
    this.route.navigate(['actualizar-empleado',id])
  }

  eliminarEmpleado(id:number){
    swal({
      title:"¿Esta seguro?",
      text:"Conformar si desea elimianr el Empleado",
      type:'warning',
      showCancelButton:true,
      confirmButtonText:'Si, Eliminar',
      cancelButtonText:'No, cancelar'
    }).then((result)=>{
      this.empleadoService.eliminarEmpleado(id).subscribe(data=>{
        this.obtenerEmpleado();
        swal('Empleado eliminado','El empleado ha sido eliminado con exito', 'success');
      });
    });
  }

}
