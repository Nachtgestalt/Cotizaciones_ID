import { Routes } from '@angular/router';
import { AdduserComponent } from './adduser/adduser.component';
import { ModifyuserComponent } from './modifyuser/modifyuser.component';

export const USUARIOS_ROUTES: Routes = [
    {path: 'usuario', component: AdduserComponent},
    {path: 'usuario/:id', component: AdduserComponent},
    {path: 'usuarios', component: ModifyuserComponent},
    { path: '**', pathMatch: 'full', redirectTo: 'usuario/nuevo'}
];
