package helloApp;

/**
* helloApp/HelloHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Hello.idl
* Segunda-feira, 23 de Outubro de 2017 10H23m BRT
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public helloApp.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (helloApp.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = helloApp.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    helloApp.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return helloApp.HelloHelper.type ();
  }

}
