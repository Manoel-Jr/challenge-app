import { Endereco } from "./endereco.model";

export interface Cliente {
    id?: number
    nome: string
    cpf: string
    dataNascimento: Date|string;
    endereco: Endereco
    sexo: string
}