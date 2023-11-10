import { Component, OnInit } from '@angular/core';
import { Empelado } from '../Empleado';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpleadoService } from '../empleado.service';
import { error } from 'console';

@Component({
  selector: 'app-actualizar-empleado',
  templateUrl: './actualizar-empleado.component.html',
  styleUrls: ['./actualizar-empleado.component.css']
})
export class ActualizarEmpleadoComponent implements OnInit {

  id!:number;
  empleado:Empelado = new Empelado();
  constructor(private empServ:EmpleadoService, private router:Router,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.empServ.obtenerEmpledoPorID(this.id).subscribe(dato=>{
      this.empleado = dato;
    },error=>console.log(error));

  }

  onSubmit(){
    this.empServ.actualizarEmpelado(this.id, this.empleado).subscribe(data=> {
      this.router.navigate(['/empleado']);
      console.log("se actualizo correctamente");
    },error=>console.log(error));
  }

}
