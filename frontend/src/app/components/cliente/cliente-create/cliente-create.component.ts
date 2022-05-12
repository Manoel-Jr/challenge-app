import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Cliente } from './../cliente.model';
import { ClienteService } from './../cliente.service';
import { Endereco } from './../endereco.model';

@Component({
  selector: 'app-cliente-create',
  templateUrl: './cliente-create.component.html',
  styleUrls: ['./cliente-create.component.css']
})
export class ClienteCreateComponent {

  endereco: Endereco = {
    cep: '',
    rua: '',
    numero: '',
    complemento: '',
    bairro: '',
    cidade: '',
    uf: ''
  };

  cliente: Cliente = {
    nome: '',
    cpf: '',
    dataNascimento: '',
    sexo: '',
    endereco: this.endereco
  }

  constructor(private clienteService: ClienteService,
    private router: Router) { }

    create(): void {
      this.clienteService.create(this.cliente).subscribe(() => {
        this.clienteService.showMessage('Cliente cadastrado com sucesso!')
        this.router.navigate(['/clientes'])
      })
  
    }
  
    cancel(): void {
      this.router.navigate(['/clientes'])
    }

}
