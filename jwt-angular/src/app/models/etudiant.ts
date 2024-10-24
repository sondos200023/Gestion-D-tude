export class Etudiant {
        id!: number;
        prenom!: string;
        nom!: string;
        classe!: {
          id: number;
          nom: string;
        };
       
  constructor() {
    // this.id = 0; 
    // // this.fname="";
    // this.lname="";
  } 
}
