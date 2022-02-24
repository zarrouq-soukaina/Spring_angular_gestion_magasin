package com.crud.aspect;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.crud.model.Commande;
@Aspect
@Component
public class FactureAspect {
	@Before(value = "execution(* com.crud.service.FactureService.*(..)) and args(fId)")
	public void beforeAdvice(JoinPoint joinPoint, String fId) {
		System.out.println("avant la methode:" + joinPoint.getSignature());
		System.out.println("suppression du Facture de l'id - "  + fId);
		}
	@After(value = "execution(* com.crud.service.FactureService.*(..)) and args(fId)")
	public void afterAdvice(JoinPoint joinPoint, String fId) {
			System.out.println("Apres la methode:" + joinPoint.getSignature());
			System.out.println("supression avec sucés de l'id - " + fId);
			}
	@Before(value = "execution(* com.crud.service.FactureService.*(..)) and args( datefacture,  modePaiement, commandesfacture)")
	public void beforeAdvice(JoinPoint joinPoint, Date datefacture, String modePaiement, Commande commandesfacture) {
	System.out.println("avant la methode:" + joinPoint.getSignature());
	System.out.println("creation de facture : date de facture - " + datefacture + " and modePaiement - " + modePaiement + "and commandesfacture" +commandesfacture);
	}
	@After(value = "execution(* com.crud.service.FactureService.*(..)) and args(datefacture,modePaiement,commandesfacture)")
	public void afterAdvice(JoinPoint joinPoint, Date datefacture, String modePaiement, Commande commandesfacture) {
	System.out.println("Apres la methode:" + joinPoint.getSignature());
	System.out.println("creation reussie de facture: datefacture - " + datefacture + " and modePaiement - " + modePaiement +   "and commandesfacture" +commandesfacture);
	}
}
