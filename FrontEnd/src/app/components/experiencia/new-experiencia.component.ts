import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ExperienciaLaboral } from 'src/app/model/experiencia-laboral';
import { SExperienciaLabService } from 'src/app/service/sexperiencia-lab.service';

@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit {
  nombreExpLab: string = '';
  descripcionExpLab: string = '';

  constructor(private sExperiencia: SExperienciaLabService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const expe = new ExperienciaLaboral(this.nombreExpLab, this.descripcionExpLab);
    this.sExperiencia.save(expe).subscribe(
      data=>{
        alert("Experiencia agregada");
        this.router.navigate(['']);
      }, err=>{
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }
  

}
