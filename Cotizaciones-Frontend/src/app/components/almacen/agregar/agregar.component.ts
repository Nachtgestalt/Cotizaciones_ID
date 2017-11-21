import { Component, OnInit } from '@angular/core';
import { FileUploaderComponent } from './../../file-uploader/file-uploader.component';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { ProductosService } from './../../../services/productos.service';
import { Http, Headers } from '@angular/http';
import { Producto } from './../../../interfaces/producto.interface';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-agregar',
  templateUrl: './agregar.component.html',
  styleUrls: ['./agregar.component.css']
})
export class AgregarComponent implements OnInit {

  formulario: FormGroup;
  valido = false;
  actualizado = false;

  private producto: Producto = {
    folio: null,
    nombre: '',
    apellido: '',
    email: '',
    empresa: '',
    telefono: '',
    direccion: '',
    tipoDePublico: '',
    serviciosDestacados: '',
    descripcionServicios: '',
    duracion: '',
    pretencion: '',
    detalles: '',
    costoDuracion: null,
    costoObjetivo: null,
    costoTipoProducto: null
  };

  nuevo: boolean = false;
  id: string;

  constructor(private _productosService: ProductosService,
    private router: Router,
    private route: ActivatedRoute) {
    this.formulario = new FormGroup({
      'nombre': new FormControl('', [Validators.required]),
      'apellido': new FormControl('', Validators.required),
      'email': new FormControl('', Validators.required),
      'empresa': new FormControl('', Validators.required),
      'telefono': new FormControl('', Validators.required),
      'direccion': new FormControl('', Validators.required),
      'tipoDePublico': new FormControl('', Validators.required),
      'serviciosDestacados': new FormControl('', Validators.required),
      'descripcionServicios': new FormControl('', Validators.required),
      'duracion': new FormControl('', Validators.required),
      'pretencion': new FormControl('', Validators.required),
      'detalles': new FormControl('', Validators.required)
    });

    this.route.params
      .subscribe(parametros => {
        console.log(parametros);
        this.id = parametros['id'];
        if (this.id !== 'nuevo') {
          this._productosService.obtenerProducto(this.id)
            .subscribe(producto => this.producto = producto);
        }
      });
  }

  ngOnInit() {}

  capturar() {
    this.producto.tipoDePublico = this.producto.tipoDePublico;
    console.log(this.producto.tipoDePublico);
  }

  guardarCambios() {
    if (this.id === 'nuevo') {
      this._productosService.agregar(this.producto)
        .subscribe(data => {
          this.valido = true;
          setTimeout(() => {
            this.formulario.reset();
            this.valido = false;
            this.router.navigate(['/dashboard/almacen/producto/nuevo']);
          }, 2000);
        });
    } else {
      this._productosService.actualizarProducto(this.producto, this.id)
        .subscribe(data => {
          this.actualizado = true;
          setTimeout(() => {
            this.formulario.reset();
            this.valido = false;
            this.router.navigate(['/dashboard/almacen/productos']);
          }, 2000);
          console.log(data);
        });
    }
  }

}
