package com.crud.aspect;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.crud.model.Client;
@Aspect
@Component
public class CommandeServiceAspect {
	@Before(value = "execution(* com.crud.service.CommandeService.*(..)) and args(cmId)")
	public void beforeAdvice(JoinPoint joinPoint, String cmId) {
		System.out.println("avant la methode:" + joinPoint.getSignature());
		System.out.println("suppression du Commande de l'id - "  + cmId);
		}
	@After(value = "execution(* com.crud.service.CommandeService.*(..)) and args(cmId)")
	public void afterAdvice(JoinPoint joinPoint, String cmId) {
			System.out.println("Apres la methode:" + joinPoint.getSignature());
			System.out.println("supression avec sucés de l'id - " + cmId);
			}
	@Before(value = "execution(* com.crud.service.CommandeService.*(..)) and args(dateCommande,total, client)")
	public void beforeAdvice(JoinPoint joinPoint, Date  dateCommande, int total, Client client) {
	System.out.println("avant la methode:" + joinPoint.getSignature());
	System.out.println("creation de la commande : name - " + dateCommande  + "and total -"+ total + "and client -"+ client);
	}
	@After(value = "execution(* com.crud.service.CommandeService.*(..)) and args(dateCommande,total, client)")
	public void afterAdvice(JoinPoint joinPoint, Date  dateCommande,  int total,Client client) {
	System.out.println("Apres la methode:" + joinPoint.getSignature());
	System.out.println("creation reussie de la commande: dateCommande - " + dateCommande  + "and total -"+ total+ "and client -"+ client);
	}
}
