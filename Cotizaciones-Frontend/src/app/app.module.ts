import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

// Rutas
import { APP_ROUTING } from './app.routes';

// Servicios
import { ProductosService } from './services/productos.service';
import { UserService } from './services/user.service';
import { CotizacionesService } from './services/cotizaciones.service';

import { AppComponent } from './app.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { MenuComponent } from './components/shared/menu/menu.component';
import { HomeComponent } from './components/home/home.component';
import { AlmacenComponent } from './components/almacen/almacen.component';
import { VentasComponent } from './components/ventas/ventas.component';
import { EstadisticasComponent } from './components/estadisticas/estadisticas.component';
import { AgregarComponent } from './components/almacen/agregar/agregar.component';
import { FileUploaderComponent } from './components/file-uploader/file-uploader.component';
import { ModificarComponent } from './components/almacen/modificar/modificar.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { LoginComponent } from './components/login/login.component';

//Pipes
import { KeysPipe } from './pipes/keys.pipe';
import { UsuariosComponent } from './components/usuarios/usuarios.component';
import { AdduserComponent } from './components/usuarios/adduser/adduser.component';
import { ModifyuserComponent } from './components/usuarios/modifyuser/modifyuser.component';
import { GenerarCostosComponent } from './components/almacen/generar-costos/generar-costos.component';
import { FooterComponent } from './components/shared/footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    MenuComponent,
    HomeComponent,
    AlmacenComponent,
    VentasComponent,
    EstadisticasComponent,
    AgregarComponent,
    FileUploaderComponent,
    ModificarComponent,
    DashboardComponent,
    LoginComponent,
    KeysPipe,
    UsuariosComponent,
    AdduserComponent,
    ModifyuserComponent,
    GenerarCostosComponent,
    FooterComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    ReactiveFormsModule,
    APP_ROUTING
  ],
  providers: [
    ProductosService,
    CotizacionesService,
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
