package com.danibuiza.jaxb.main;

import java.io.File;
import java.time.LocalDate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.danibuiza.jaxb.museum.Exhibition;
import com.danibuiza.jaxb.museum.Museum;

/**
 * Simple example of usage of jaxb marshaling functionalities when managing complex classes
 * 
 * @author dgutierrez-diez
 */
public class MuseumJaxBExampleComplexClasses
{

    public static void main( String[] args )
    {
        try
        {

            /* init very simple data to marshal */
            Museum simpleMuseum = new Museum();
            simpleMuseum.setName( "Simple Museum" );
            simpleMuseum.setCity( "Oviedo, Spain" );

            simpleMuseum.setChildrenAllowed( false );

            /* add one permanent exhibition to the museum */
            Exhibition exhibition = new Exhibition();
            exhibition.setName( "one exhibition" );
            exhibition.setFrom( LocalDate.of( 2014, 01, 01 ) );

            simpleMuseum.setPermanent( exhibition );

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance( Museum.class );
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal( simpleMuseum, new File( "simple.xml" ) );
            jaxbMarshaller.marshal( simpleMuseum, System.out );

        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
