import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { JwtService } from 'src/app/service/jwt.service'; //Service utilisé pour envoyer les données du formulaire au serveur.
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  registerForm: FormGroup | undefined; //le nom de formulaire dans le html

  constructor(
    private service: JwtService, //Utilisé pour envoyer les données d'inscription au backend.
    private fb: FormBuilder, //Simplifie la création des contrôles de formulaire.
    private router: Router

  ) { }

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name: ['', [Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required]],
      confirmPassword: ['', [Validators.required]],
    }, { validator: this.passwordMathValidator })
  }

  passwordMathValidator(formGroup: FormGroup) {
    const password = formGroup.get('password')?.value;
    const confirmPassword = formGroup.get('confirmPassword')?.value;
    if (password != confirmPassword) {
      formGroup.get('confirmPassword')?.setErrors({ passwordMismatch: true });
    } else {
      formGroup.get('confirmPassword')?.setErrors(null);
    }
  }

  submitForm() { //  Affiche les données du formulaire dans la console et appelle la méthode register() du JwtService pour envoyer les données au backen
    console.log(this.registerForm.value);
    this.service.register(this.registerForm.value).subscribe(  //utilisé la methode register du service jwt pour l'inscription
      (response) => {
        if (response.id != null) {
          alert("Hello " + response.name);
          this.router.navigateByUrl("/login");
        }
      }
    )
  }

}
