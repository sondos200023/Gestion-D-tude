package tn.testTech.dto;

public record LoginResponse(String jwt) {
//record c est une classe pour simplifié la creation des classes non changeable(immuable)et pas d'heritage
	//Contient automatiquemment l'attribut jwt avec getters,setters ,constructeurs,ToString
}
