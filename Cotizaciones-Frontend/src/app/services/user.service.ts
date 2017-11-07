import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import { User } from './../interfaces/user.interface';
import 'rxjs/Rx';

@Injectable()
export class UserService {

  serverURL = 'http://localhost:8080/logincheck';
  usuarioURL = 'http://localhost:8080/usuarios/nuevo';
  usuariosURL = 'http://localhost:8080/usuarios';

  constructor(private http: Http,
              private router: Router,
              private activatedRoute: ActivatedRoute) { }

  autenticar(user: User) {
    let body = JSON.stringify(user);
    let headers = new Headers({
      'Content-Type': 'application/json'
    });

    console.log(body);

    return this.http.post(this.serverURL, body, {headers})
            .map( res => {
              console.log(res.json());
              return res.json();
            })
  }

  agregarUsuario(user: User){
    let body = JSON.stringify(user);
    let headers = new Headers({
      'Content-Type': 'application/json'
    });

    console.log(body);

    return this.http.post(this.usuarioURL, body, { headers })
      .map(res => {
        console.log(res.json());
        return res.json();
      })
  }

  obtenerUsuarios(){
    return this.http.get( this.usuariosURL)
            .map( res => res.json() );
  }

  obtenerUsuario(key$: string){
    let url = `${ this.usuariosURL}/${key$}`;
    return this.http.get(url)
                .map( res => res.json());
  }

  borrarUsuario(key$:string){
    let url = `${ this.usuariosURL}/${key$}`;
    return this.http.delete(url)
            .map(res => res.json)
  }

}
