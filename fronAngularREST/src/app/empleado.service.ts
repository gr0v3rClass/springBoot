import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Empelado } from './Empleado';

@Injectable({
  providedIn: 'root'
})
export class EmpleadoService {

  private baseURL = "http://localhost:8080/api/v1/empleados"

  constructor(private httpClient:HttpClient) { }

  obtenerListaEmpleados():Observable<Empelado[]>{
    return this.httpClient.get<Empelado[]>(`${this.baseURL}`);
  }

  nuevoEmpleado(empleado:Empelado):Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, empleado);
  }

  obtenerEmpledoPorID(id:number):Observable<Empelado>{
    return this.httpClient.get<Empelado>(`${this.baseURL}/${id}`);
  }

  actualizarEmpelado(id:number, empleado:Empelado):Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`,empleado);
  }

  eliminarEmpleado(id:number):Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
