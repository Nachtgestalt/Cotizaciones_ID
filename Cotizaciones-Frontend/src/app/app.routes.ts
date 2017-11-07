import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AlmacenComponent } from './components/almacen/almacen.component';
import { VentasComponent } from './components/ventas/ventas.component';
import { EstadisticasComponent } from './components/estadisticas/estadisticas.component';
import { DASHBOARD_ROUTES } from './components/dashboard/dashboard.routes';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';
import { UsuariosComponent } from './components/usuarios/usuarios.component';

import { ALMACEN_ROUTES } from './components/almacen/almacen.routes';
import { USUARIOS_ROUTES } from './components/usuarios/usuarios.routes';

const APP_ROUTES: Routes = [
  { path: 'almacen',
    component: AlmacenComponent,
    children : ALMACEN_ROUTES
  },
  {
    path: 'usuarios',
    component: UsuariosComponent,
    children : USUARIOS_ROUTES
  },
  { path: 'dashboard',
    component: DashboardComponent,
    children: DASHBOARD_ROUTES },
  { path: 'login', component: LoginComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'login'}
];

export class NameRoutingModule { }
export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES);