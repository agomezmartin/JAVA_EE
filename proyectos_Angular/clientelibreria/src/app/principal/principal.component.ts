import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {

  empresa:string = "Aventuras S.L";
  nombre:string = "Alberto"

  constructor() { }

  ngOnInit(): void {
  }

}
