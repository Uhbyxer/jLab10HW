package com.danibuiza.jaxb.main;

import java.io.File;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.danibuiza.jaxb.museum.Exhibition;
import com.danibuiza.jaxb.museum.Museum;
import com.danibuiza.jaxb.museum.Museums;

/**
 * This class contains a main method that shows how to use the JAXB marshaling functionalities. The
 * example writes a list of museums, containing name, city and exhibitions in an xml file using jaxb
 * 
 * @author dgutierrez-diez
 */
public class MuseumJaxBExampleComplete
{

    public static void main( String[] args )
    {
        try
        {

            /* init data to marshal */
            Museum reinaSofia = new Museum();
            reinaSofia.setName( "Reina Sofia Museum" );
            reinaSofia.setCity( "Madrid" );
            Exhibition permanent = new Exhibition();
            permanent.setName( "Permanent Exhibition - Reina Sofia Museum" );
            permanent.setFrom( LocalDate.of( 1900, Month.JANUARY, 1 ) );
            permanent.setTo( LocalDate.of( 2014, Month.DECEMBER, 31 ) );
            List<String> artistsReinaSofia = new ArrayList<String>();
            artistsReinaSofia.add( "Picasso" );
            artistsReinaSofia.add( "Dali" );
            artistsReinaSofia.add( "Miro" );
            permanent.setArtists( artistsReinaSofia );
            reinaSofia.setPermanent( permanent );

            Museum prado = new Museum();
            prado.setName( "Prado Museum" );
            prado.setCity( "Madrid" );
            Exhibition permanentPrado = new Exhibition();
            permanentPrado.setName( "Permanent Exhibition - Prado Museum" );
            permanentPrado.setFrom( LocalDate.of( 1500, Month.JANUARY, 1 ) );
            permanentPrado.setTo( LocalDate.of( 2000, Month.DECEMBER, 31 ) );
            List<String> artistsPrado = new ArrayList<String>();
            artistsPrado.add( "Velazquez" );
            artistsPrado.add( "Goya" );
            artistsPrado.add( "Zurbaran" );
            artistsPrado.add( "Tiziano" );
            permanentPrado.setArtists( artistsPrado );
            prado.setPermanent( permanentPrado );

            Exhibition special = new Exhibition();
            special.setName( "Game of Bowls (1908), by Henri Matisse" );
            special.setFrom( LocalDate.of( 1908, Month.JANUARY, 1 ) );
            special.setTo( LocalDate.of( 1908, Month.DECEMBER, 31 ) );
            List<String> artistsSpecial = new ArrayList<String>();
            artistsSpecial.add( "Mattise" );
            special.setArtists( artistsSpecial );
            prado.setSpecial( special );

            Museums museums = new Museums();
            museums.add( prado );
            museums.add( reinaSofia );

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Museums.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( museums, new File( "museums.xml" ) );
            jaxbMarshaller.marshal( museums, System.out );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
