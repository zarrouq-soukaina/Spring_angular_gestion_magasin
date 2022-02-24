package com.crud.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component

public class ProduitServiceAspect {
	@Before(value = "execution(* com.crud.service.ProduitService.*(..)) and args(pId)")
	public void beforeAdvice(JoinPoint joinPoint, String pId) {
		System.out.println("avant la methode:" + joinPoint.getSignature());
		System.out.println("suppression du produit de l'id - "  + pId);
		}
	@After(value = "execution(* com.crud.service.ProduitService.*(..)) and args(pId)")
	public void afterAdvice(JoinPoint joinPoint, String pId) {
			System.out.println("Apres la methode:" + joinPoint.getSignature());
			System.out.println("supression avec sucés de l'id - " + pId);
			}
	@Before(value = "execution(* com.crud.service.ProduitService.*(..)) and args(designation,prix,tva)")
	public void beforeAdvice(JoinPoint joinPoint, String designation, int prix, int tva) {
	System.out.println("avant la methode:" + joinPoint.getSignature());
	System.out.println("creation de l’employe : name - " + designation + " and prix - " + prix + "and tva -"+ tva);
	}
	@After(value = "execution(* com.crud.service.ProduitService.*(..)) and args(designation,prix,tva)")
	public void afterAdvice(JoinPoint joinPoint, String designation, int prix, int tva) {
	System.out.println("Apres la methode:" + joinPoint.getSignature());
	System.out.println("creation reussie de l’employe: designation - " + designation + " and prix - " + prix + "and tva -"+ tva);
	}

}
