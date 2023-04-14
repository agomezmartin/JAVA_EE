import { Component } from '@angular/core';
/*
A través de la anotación @Component se se le dice
- la PLANTILLA a la que va a asociado
- la HOJA DE ESTILOS a la que va asociado
/ */
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title:string = "título";
  subtitle:string = "subtítulo";

  empresa:string = "Aventuras S.L";
  nombre:string = "Alberto"

}
