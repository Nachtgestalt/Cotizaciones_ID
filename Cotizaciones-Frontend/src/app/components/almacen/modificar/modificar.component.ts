import { Component, OnInit } from '@angular/core';
import { ProductosService } from './../../../services/productos.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-modificar',
  templateUrl: './modificar.component.html',
  styleUrls: ['./modificar.component.css']
})
export class ModificarComponent implements OnInit {

  eliminado = false;

  productos: any[] = [];

  constructor( private _productosService: ProductosService,
                private router: Router) {
    this._productosService.obtenerProductos()
        .subscribe( data => {
          console.log(data);
          this.productos = data;
        })
   }

  ngOnInit() {
  }

  borrarProducto(key$: string, k: string){
    if(confirm('¿Esta seguro de eliminar este producto?')) {
      this._productosService.borrarProducto(key$)
        .subscribe( respuesta => {
          console.log(this.productos, "se borro esta madre");
          delete this.productos[k];
        });
    }
  }
}