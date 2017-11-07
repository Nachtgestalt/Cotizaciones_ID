import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import { User } from './../../../interfaces/user.interface';
import { UserService } from './../../../services/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Http, Headers } from '@angular/http';

@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {

  formulario: FormGroup;
  valido = true;

  private user: User = {
    username: '',
    password: ''
  };

  id: string;

  constructor(private _userService: UserService,
    private router: Router,
    private route: ActivatedRoute) {

    this.formulario = new FormGroup({
      'username': new FormControl('', Validators.required),
      'password': new FormControl('', Validators.required)
    });

    this.route.params
      .subscribe(parametros => {
        console.log(parametros);
        this.id = parametros['id'];
        if (this.id !== 'nuevo') {
          this._userService.obtenerUsuario(this.id)
            .subscribe(user => this.user = user);
        }
      });
  }

  ngOnInit() {
  }

  guardarCambios() {
    if (this.id === 'nuevo') {
      this._userService.agregarUsuario(this.user)
        .subscribe(data => {
          this.valido = true;
          setTimeout(() => {
            this.formulario.reset();
            this.valido = false;
            this.router.navigate(['/dashboard/usuarios/nuevo']);
          }, 2000);
        });
    } else {
      // this._userService.actualizarProducto(this.producto, this.id)
      //   .subscribe(data => {
      //     this.actualizado = true;
      //     setTimeout(() => {
      //       this.formulario.reset();
      //       this.valido = false;
      //       this.router.navigate(['/dashboard/almacen/productos']);
      //     }, 2000);
      //     console.log(data);
      //   });
    }
  }

}
