import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Http, Headers } from '@angular/http';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from './../../services/user.service';
import { User } from './../../interfaces/user.interface';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  formulario: FormGroup;
  valido = true;

  user: User = {
    username: '',
    password: ''
  };

  constructor(private _userService: UserService,
              private router: Router) {

              this.formulario = new FormGroup({
                'username': new FormControl('admin', Validators.required ),
                'password': new FormControl('admin', Validators.required)
              });
  }

  ngOnInit() {
  }

  login() {
    console.log(this.user);
    this._userService.autenticar(this.user)
        .subscribe( data => {
            console.log('holis');
            this.router.navigate(['/dashboard']);
        },
        error => {
          this.valido = false;
        })
  }
}