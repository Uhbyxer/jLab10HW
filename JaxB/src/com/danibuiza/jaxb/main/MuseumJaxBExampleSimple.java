package com.danibuiza.jaxb.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.danibuiza.jaxb.museum.Museum;

/**
 * Simple example of usage of jaxb marshaling functionalities
 * 
 * @author dgutierrez-diez
 */
public class MuseumJaxBExampleSimple
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
