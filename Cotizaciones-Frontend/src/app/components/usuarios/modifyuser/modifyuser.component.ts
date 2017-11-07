import { Component, OnInit } from '@angular/core';
import { UserService } from './../../../services/user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-modifyuser',
  templateUrl: './modifyuser.component.html',
  styleUrls: ['./modifyuser.component.css']
})
export class ModifyuserComponent implements OnInit {

  usuarios: any[] = [];

  constructor(private _userService: UserService,
    private router: Router) {

    this._userService.obtenerUsuarios()
      .subscribe(data => {
        console.log(data);
        this.usuarios = data;
      })
  }

  ngOnInit() {
  }

  borrarUsuario(key$: string, k: string) {
    if(confirm('¿Esta seguro de eliminar este usuario?')) {
      this._userService.borrarUsuario(key$)
        .subscribe(respuesta => {
          console.log(this.usuarios);
          delete this.usuarios[k];
        })
    }
  }

}
