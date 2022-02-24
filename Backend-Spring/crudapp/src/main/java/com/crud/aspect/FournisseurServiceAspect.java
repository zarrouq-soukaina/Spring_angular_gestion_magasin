package com.crud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FournisseurServiceAspect {
	@Before(value = "execution(* com.crud.service.FournisseurService.*(..)) and args(frId)")
	public void beforeAdvice(JoinPoint joinPoint, String frId) {
		System.out.println("avant la methode:" + joinPoint.getSignature());
		System.out.println("suppression du Fournisseur de l'id - "  + frId);
		}
	@After(value = "execution(* com.crud.service.FournisseurService.*(..)) and args(frId)")
	public void afterAdvice(JoinPoint joinPoint, String frId) {
			System.out.println("Apres la methode:" + joinPoint.getSignature());
			System.out.println("supression avec sucés de l'id - " + frId);
			}
	@Before(value = "execution(* com.crud.service.FournisseurService.*(..)) and args(nom,prenom,adresse,tel)")
	public void beforeAdvice(JoinPoint joinPoint, String nom, String prenom, String adresse, int tel) {
	System.out.println("avant la methode:" + joinPoint.getSignature());
	System.out.println("creation de l’employe : name - " + nom + " and prenom - " + prenom + "and tel -"+ tel + "and adresse" +adresse);
	}
	@After(value = "execution(* com.crud.service.FournisseurService.*(..)) and args(nom,prenom,adresse,tel)")
	public void afterAdvice(JoinPoint joinPoint, String nom, String prenom, String adresse, int tel) {
	System.out.println("Apres la methode:" + joinPoint.getSignature());
	System.out.println("creation reussie de l’employe: nom - " + nom + " and prenom - " + prenom + "and tel -"+ tel+ "and adresse" +adresse);
	}
}

