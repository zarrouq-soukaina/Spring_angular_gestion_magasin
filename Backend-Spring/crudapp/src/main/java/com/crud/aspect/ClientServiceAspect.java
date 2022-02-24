package com.crud.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ClientServiceAspect {
	@Before(value = "execution(* com.crud.service.ClientService.*(..)) and args(cId)")
	public void beforeAdvice(JoinPoint joinPoint, String cId) {
		System.out.println("avant la methode:" + joinPoint.getSignature());
		System.out.println("suppression du Client de l'id - "  + cId);
		}
	@After(value = "execution(* com.crud.service.ClientService.*(..)) and args(cId)")
	public void afterAdvice(JoinPoint joinPoint, String cId) {
			System.out.println("Apres la methode:" + joinPoint.getSignature());
			System.out.println("supression avec sucés de l'id - " + cId);
			}
	@Before(value = "execution(* com.crud.service.ClientService.*(..)) and args(nom,prenom,adresse,tel)")
	public void beforeAdvice(JoinPoint joinPoint, String nom, String prenom, String adresse, int tel) {
	System.out.println("avant la methode:" + joinPoint.getSignature());
	System.out.println("creation de l’employe : name - " + nom + " and prenom - " + prenom + "and tel -"+ tel + "and adresse" +adresse);
	}
	@After(value = "execution(* com.crud.service.ClientService.*(..)) and args(nom,prenom,adresse,tel)")
	public void afterAdvice(JoinPoint joinPoint, String nom, String prenom, String adresse, int tel) {
	System.out.println("Apres la methode:" + joinPoint.getSignature());
	System.out.println("creation reussie de l’employe: nom - " + nom + " and prenom - " + prenom + "and tel -"+ tel+ "and adresse" +adresse);
	}
}
