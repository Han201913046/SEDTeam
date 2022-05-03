/*
 * Restaurant Booking System: example code to accompany
 *
 * "Practical Object-oriented Design with UML"
 * Mark Priestley
 * McGraw-Hill (2004)
 */

package booksys.application.persistency ;

import booksys.application.domain.Customer;

public class PersistentCustomer extends Customer
{
  private int oid ;

  PersistentCustomer(int id, String n, String p)
  {
    super(n, p) ;
    oid = id ;
  }

  public int getId() {
    return oid ;
  }
}
