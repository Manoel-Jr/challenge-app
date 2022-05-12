import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderService } from 'src/app/components/template/header/header.service';

@Component({
  selector: 'app-cliente-crud',
  templateUrl: './cliente-crud.component.html',
  styleUrls: ['./cliente-crud.component.css']
})
export class ClienteCrudComponent {

  constructor(private router: Router, private headerService: HeaderService) {
    headerService.headerData = {
      title: 'Cadastro de Clientes',
      icon: 'person_add',
      routeUrl: '/clientes'
    }
  }

  navigateToClienteCreate(): void {
    this.router.navigate(['/clientes/create'])
  }
}
