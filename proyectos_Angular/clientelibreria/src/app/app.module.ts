import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { PrincipalComponent } from './principal/principal.component';
import { SecundarioComponent } from './secundario/secundario.component';
/*
Es un archivo de CONFIGURACIÓN.
Esta anotación nos permite:

- Declarar cada COMPONENTE
- Importar COMPONENTES o MÓDULOS ESPECIALES de la aplicación
- Especificar SERVICIOS (Iimplementar la lógica de negocio) (PROVEEDORES)

 */
@NgModule({
  declarations: [

    // Se especifica el COMPONENTE
    AppComponent,
     PrincipalComponent,
     SecundarioComponent
  ],
  imports: [
    BrowserModule
  ],


  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
