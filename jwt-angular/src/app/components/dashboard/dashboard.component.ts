import { Component } from '@angular/core';
import { JwtService } from 'src/app/service/jwt.service';
import { Router } from '@angular/router'; 
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {


  message: string;

  constructor(
    private service: JwtService,
    private router: Router
  ) { }
  

  ngOnInit() {
    this.hello();
  }

  hello() {
    this.service.hello().subscribe(
      (response) => {
        console.log(response);
        this.message = response.message;
      }
    )
  }
  navigateToList(): void {
    this.router.navigate(['/etudiants']);
  }
  
}
