export class JwtDto {
    // el signo ! es para no inicializar las variables
    token!: string;
    type!: string;
    nombreUsuario!: string;
    authorities!: string[];
}
