package data.client;

/*
 * This interface helps abstract the comparisons. It takes the
 * Class A/B and the implemented function would compare between the two
 */

interface CompareTwoObjects<A,B> {
	public boolean compare(A a,B b);
}