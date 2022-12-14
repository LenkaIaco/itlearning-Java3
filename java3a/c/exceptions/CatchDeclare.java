package sk.itlearning.java3.java3a.c.exceptions;

import java.math.BigDecimal;

public class CatchDeclare {

	public static void main(String[] args) {

		BigDecimal a = new BigDecimal(10);
		
		BigDecimal b = a.divide(new BigDecimal(0));//*big decimal sa deli cez metodu divide. delenie nula sa neda, nastane fatalna chyba division byzero. Prep\kvapujuco metoda nenuti compulsory try catch, kedze pri aritm operaciach sa stava ze moze byt delenie invalid ako 0 a potom to nefunguje
		/*
		 * urobime vlastnu verziu metody divide kt nas donuti pocitat s tym ze moze nastat error ze tam moze skoncit nula. Ako - oddedime triedu a potom si poprepiujeme triedu BigDecimal podla vlast predstav
		 * private static class CustomBigDecimal extends BigDecimal {
		 * tu nam vyskoci chyba lebo robime vlast triedu custor ale nenapiseme este vlast konstruktor java nam chce podsunut default konstruktor bez parametra super() a automaticky zavolat superkonstruktor(bezparametrovy) lenze v BigDecimal superkonstruktor neexistuje
		 * superkonstruktor - tried A ma int a, konstruktor public A (){ a =20} - trieda neni staticka vznikne az tym a = 20.
		 * Potom ur. tr. B kde prepiseme int b public B (){b = 20;} 
		 * potom urobime main {B b = new B();
		 * b.a - to ked vypiseme tak je 0 lebo ked sme urobili  triedu B tak sme neinicializovali extra a takze je 0.
		 * To sa riesi tym ze do A dam superkonstruktor super(); potom a = 20. Potom ked B robim tak tiez najpr zavolam super() potom B a potom uz spozna a ako s  hodnotou lebo super automaticky skonstruuje triedu odhora dole 
		 * 
		 */
		/*
		 * private static class CustomBigDecimal extends BigDecimal {
		 * public CustomBigDecimal (double n) {
		 * super(n)}
		 * @Override
		 *public BigDecimal divide BigDecimal divisor) throws DivisionByZeroException {
		 * return super.divide(divisor)
		 * -toto by Override islo iba ak by v BigDecimal existovala throws metoda ktoru overridneme. Kedze neex. tak vyhodi error. Cize musime miesto BigDecimal overridovat CustomBigDecimal:
		 * -uz nepiseme Override hore! lebo definujeme novu
		 * public BigDecimal divide CustomBigDecimal divisor) throws DivisionByZeroException {
		 * try {
			return super.divide(divisor);
		} catch (ArithmeticException e) {
		if (divisor.doubleValue() == 0;) {
		throw new DivisionByZeroException();//tzv. rethrow exception
		}
			e.printStackTrace();
		}
		
		 * }
		 */
		System.out.println(b);

		CustomBigDecimal c = new CustomBigDecimal(10.0);//to iste co hore v poznamkach urobime tu s nasim custombigdecimalom a s mojou metodou divide a uz keby sme dali do (0) tak nas nuti pouzit try catch

		try {
			c.divide(new CustomBigDecimal(0.0));
		} catch (DivisionByZeroException e) {
			e.printStackTrace();
		}
		
		System.out.println("... a program pokracuje dalej");
	}
	/*predosle verzie ako sa toto dole riesilo:
	 *big decimal sa deli cez metodu divide. delenie nula sa neda, nastane fatalna chyba division byzero
	 */
	
//odtialto je to najnovsia varianta riesenia tohto scenaru cez kod v jave
	private static class CustomBigDecimal extends BigDecimal {

		private static final long serialVersionUID = 1L;

		public CustomBigDecimal(double d) {
			super(d);
		}

		public CustomBigDecimal divide(CustomBigDecimal divisor) throws DivisionByZeroException {//nas custombigdecimal sa da s try catch uz pouzit, pouzili sme custombigdecimal a v nej nasu custom metodu divide cize uz nepotrebujeme pisat override z divide kedze uz je nacustomizovana
			try {
				return new CustomBigDecimal(super.divide(divisor).doubleValue());
			} catch (ArithmeticException e) {
			
			if (divisor.doubleValue() == 0) {//alebo 0.0
				throw new DivisionByZeroException();
			} else {
				return super.divide(divisor);
			}
		}
	}

}
