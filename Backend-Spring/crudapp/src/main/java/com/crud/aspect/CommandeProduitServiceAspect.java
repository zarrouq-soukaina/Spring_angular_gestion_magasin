package com.crud.aspect;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.crud.model.Client;
import com.crud.model.Commande;
import com.crud.model.Produit;
@Aspect
@Component
public class CommandeProduitServiceAspect {
	@Before(value = "execution(* com.crud.service.CommandeProduitService.*(..)) and args(Id)")
	public void beforeAdvice(JoinPoint joinPoint, String Id) {
		System.out.println("avant la methode:" + joinPoint.getSignature());
		System.out.println("suppression du CommandeProduit de l'id - "  + Id);
		}
	@After(value = "execution(* com.crud.service.CommandeProduitService.*(..)) and args(Id)")
	public void afterAdvice(JoinPoint joinPoint, String Id) {
			System.out.println("Apres la methode:" + joinPoint.getSignature());
			System.out.println("supression avec sucés de l'id - " + Id);
			}
	@Before(value = "execution(* com.crud.service.CommandeProduitService.*(..)) and args(produit,commande,prix, qteCom)")
	public void beforeAdvice(JoinPoint joinPoint, Produit produit , Commande commande, int prix, int qteCom) {
	System.out.println("avant la methode:" + joinPoint.getSignature());
	System.out.println("creation de la commandeProduit : produit - " + produit  + "and commande -"+ commande + "and prix -"+ prix + "and quantité commandée -"+ qteCom);
	}
	@After(value = "execution(* com.crud.service.CommandeProduitService.*(..)) and args(produit,commande,prix, qteCom)")
	public void afterAdvice(JoinPoint joinPoint, Produit produit , Commande commande, int prix, int qteCom) {
	System.out.println("Apres la methode:" + joinPoint.getSignature());
	System.out.println("creation reussie de la commandeProduit: produit - " + produit +  "and commande -"+ commande + "and prix -"+ prix + "and quantité commandée -"+ qteCom);
	}
}
