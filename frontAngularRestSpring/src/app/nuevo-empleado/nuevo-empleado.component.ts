import { Component, OnInit } from '@angular/core';
import { Empelado } from '../Empleado';
import { EmpleadoService } from '../empleado.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nuevo-empleado',
  templateUrl: './nuevo-empleado.component.html',
  styleUrls: ['./nuevo-empleado.component.css']
})
export class NuevoEmpleadoComponent implements OnInit {

  empleado:Empelado = new Empelado();

  constructor(private emplServ:EmpleadoService, private route:Router) { }

  ngOnInit(): void {
  }

  guardarEmpleado(){
    this.emplServ.nuevoEmpleado(this.empleado).subscribe(dato=>{
      this.irAlListado();
    }, error=>console.log(error));
  }

  irAlListado(){
    this.route.navigate(['/empleado']);
  }

  onSubmit(){
    this.guardarEmpleado();
  }
}
