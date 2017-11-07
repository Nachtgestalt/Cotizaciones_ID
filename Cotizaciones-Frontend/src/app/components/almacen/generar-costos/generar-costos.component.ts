import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

import { ProductosService } from './../../../services/productos.service';
import { Producto } from './../../../interfaces/producto.interface';

@Component({
  selector: 'app-generar-costos',
  templateUrl: './generar-costos.component.html',
  styleUrls: ['./generar-costos.component.css']
})
export class GenerarCostosComponent implements OnInit {

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
    detalles: ''
  };

  eliminado = false;
  productos: any[] = [];
  formulario: FormGroup;

  nuevo: boolean = false;
  id: string;

  mostrar: boolean = false;
  publico: string;

  total = 0;

  constructor( private _productosService: ProductosService,
                private router: Router) {

    this.formulario = new FormGroup({
      'folio' : new FormControl('Num. de folio'),
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
      'detalles': new FormControl('', Validators.required),
      'suma': new FormControl(),
      'costoTipoPublico' : new FormControl(),
      'costoDuracion' : new FormControl(),
      'costoPretencion' : new FormControl()
    });

    this.formulario.controls['folio'].valueChanges.subscribe(data => {
      console.log(this.productos[data]);
      this.producto = this.productos[data];
      this.mostrar = true;
    })

    this.formulario.controls['tipoDePublico'].valueChanges.subscribe(data => {
      console.log(this.producto.tipoDePublico);
      switch (this.producto.tipoDePublico) {
        case 'Local':
          this.formulario.controls['costoTipoPublico'].setValue(3000);
          break;
        case 'Regional':
          this.formulario.controls['costoTipoPublico'].setValue(5000);
          break;
        case 'Nacional':
          this.formulario.controls['costoTipoPublico'].setValue(7000);
          break;
        case 'Internacional':
            this.formulario.controls['costoTipoPublico'].setValue(10000);
            break;
      }
      this.publico = this.producto.tipoDePublico;
      this.total += this.formulario.get('costoTipoPublico').value;
      this.formulario.controls['suma'].setValue(this.total);
    })

    this.formulario.controls['duracion'].valueChanges.subscribe(data => {
      console.log(this.producto.duracion);
      switch (this.producto.duracion) {
        case '3 meses':
          this.formulario.controls['costoDuracion'].setValue(3000);
          break;
        case '6 meses':
          this.formulario.controls['costoDuracion'].setValue(5000);
          break;
        case '12 meses':
          this.formulario.controls['costoDuracion'].setValue(7000);
          break;
      }
      this.total += this.formulario.get('costoDuracion').value;
      this.formulario.controls['suma'].setValue(this.total);
    })

    this.formulario.controls['pretencion'].valueChanges.subscribe(data => {
      console.log(this.producto.pretencion);
      switch (this.producto.pretencion) {
        case 'Productos y servicios':
          this.formulario.controls['costoPretencion'].setValue(3000);
          break;
        case 'Promociones':
          this.formulario.controls['costoPretencion'].setValue(5000);
          break;
        case 'Difusion de la marca':
          this.formulario.controls['costoPretencion'].setValue(7000);
          break;
      }
      this.total += this.formulario.get('costoPretencion').value;
      this.formulario.controls['suma'].setValue(this.total);
    })

    this._productosService.obtenerProductos()
        .subscribe( data => {
          this.productos = data;
        });
  }

  ngOnInit() {
  }

  mostrarDatos(folio) {
    this.mostrar = !this.mostrar;
    console.log(this.formulario.value);
    console.log('Recibo el id' + folio);
  }
}
