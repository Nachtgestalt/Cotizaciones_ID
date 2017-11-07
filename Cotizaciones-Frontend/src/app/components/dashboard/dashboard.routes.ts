import { Routes } from '@angular/router';
import { AlmacenComponent } from './../almacen/almacen.component';
import { EstadisticasComponent } from './../estadisticas/estadisticas.component';
import { HomeComponent } from './../home/home.component';
import { VentasComponent } from './../ventas/ventas.component';
import { UsuariosComponent } from './../usuarios/usuarios.component';

import { ALMACEN_ROUTES } from './../almacen/almacen.routes';
import { USUARIOS_ROUTES } from './../usuarios/usuarios.routes';
export const DASHBOARD_ROUTES: Routes = [
    {path: 'almacen',
        component: AlmacenComponent,
        children: ALMACEN_ROUTES},
    {
        path: 'usuarios',
        component: UsuariosComponent,
        children: USUARIOS_ROUTES
    },
    {path: 'home', component: HomeComponent},
    {path: 'ventas', component: VentasComponent},
    {path: 'estadisticas', component: EstadisticasComponent}, 
    { path: '**', pathMatch: 'full', redirectTo: 'home'}
];
