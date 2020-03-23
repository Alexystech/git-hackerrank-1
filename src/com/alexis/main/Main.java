/*
*algoritmo para convertir la hora normal
*al horario militar (24hrs)
*/
package com.alexis.main;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main
{

  private static InputStreamReader isr = new InputStreamReader(System.in);
  private static BufferedReader br = new BufferedReader(isr);

  public static void main(String[] args)
  {
    System.out.println(timeConversion("12:07:00am"));
  }

  private static String timeConversion(String s)
  {

    short hora = Short.parseShort(s.substring(0,2));
    short minutos = Short.parseShort(s.substring(3,5));
    short segundos = Short.parseShort(s.substring(6,8));
    String diferenciador = s.substring(s.length()-2,s.length());
    String fullText = "";

    if (diferenciador.equalsIgnoreCase("pm"))
    {
      if (hora == 12)
      {
        fullText = conversionCadena(hora,minutos,segundos);
      }
      else
      {
        hora+=12;
        fullText = conversionCadena(hora,minutos,segundos);
      }
    }
    else
    {
      if (hora == 12)
      {
        hora -= 12;
        fullText = conversionCadena(zeroConversor(hora),minutos,segundos);
      }
      else
      {
        fullText = conversionCadena(hora,minutos,segundos);
      }
    }

    return fullText;
  }

  private static String conversionCadena(short hora,
    short minutos,
    short segundos)
  {

    String textHora = "";
    String textMinutos = "";
    String textSegundos = "";

    if (hora == 0)
    {
      textHora = zeroConversor(hora);
    }
    else
    {
      if (hora < 10)
      {
        textHora = "0"+Short.toString(hora);
      }
      else
      {
        textHora = Short.toString(hora);
      }
    }

    if (minutos == 0)
    {
      textMinutos = zeroConversor(minutos);
    }
    else
    {
      if (minutos < 10)
      {
        textMinutos = "0"+Short.toString(minutos);
      }
      else
      {
        textMinutos = Short.toString(minutos);
      }
    }

    if (segundos == 0)
    {
      textSegundos = zeroConversor(segundos);
    }
    else
    {
      if (segundos < 10)
      {
        textSegundos = "0"+Short.toString(segundos);
      }
      else
      {
        textSegundos = Short.toString(segundos);
      }
    }

    return textHora+":"+textMinutos+":"+textSegundos;
  }

//en caso de completar el ciclo de las 24 hrs

/*
*este es un caso muy puntual sobre el algoritmo
* si el reloj marca las 12 am estamos de acuerdo que
* en el horario militar debe marcar las 00:00:00
* por lo menos en el parametro de la hora
*/

  private static String conversionCadena(String textHora,
  short minutos,
  short segundos)
  {

    String textMinutos = "";
    String textSegundos = "";

    if (minutos == 0)
    {
      textMinutos = zeroConversor(minutos);
    }
    else
    {
      if (minutos < 10)
      {
        textMinutos = "0"+Short.toString(minutos);
      }
      else
      {
        textMinutos = Short.toString(minutos);
      }
    }

    if (segundos == 0)
    {
      textSegundos = zeroConversor(segundos);
    }
    else
    {
      if (segundos < 10)
      {
        textSegundos = "0"+Short.toString(segundos);
      }
      else
      {
        textSegundos = Short.toString(segundos);
      }
    }

    return textHora+":"+textMinutos+":"+textSegundos;
  }

//retornar dos ceros

/*
*necesito en casos muy puntuales que se valide si
*un valor "x" es igual a cero, de ser ese el caso
*necesito retornar dos ceros para el reloj en un string
*ya que si retorno de forma short solo tendre un cero
*en el reloj y no cumplire con los test establecidos
*/

  private static String zeroConversor(short valor)
  {
    String textValor = Short.toString(valor);

    return textValor+"0";
  }
}
