import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import { Producto } from './../interfaces/producto.interface';

import 'rxjs/add/operator/map';

@Injectable()
export class CotizacionesService {
    serverURL: string = 'http://localhost:8080/productos/cotizacion';
    obtenerURL: string = 'http://localhost:8080/productos';
    constructor(private http: Http,
      private router: Router,
      private activatedRoute: ActivatedRoute) { }
  
    agregar(producto: Producto) {
      let body = JSON.stringify(producto);
      let headers = new Headers({
        'Content-Type': 'application/json'
      });
      console.log(body);
      return this.http.post(this.serverURL, body, { headers })
        .map(res => {
          console.log(res.json());
          return res.json();
        })
    }

}
