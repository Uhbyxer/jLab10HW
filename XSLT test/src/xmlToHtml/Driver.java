package xmlToHtml;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class Driver {

    public static void main(String[] args)
    {
        try
        {
            TransformerFactory tFactory = TransformerFactory.newInstance();

            Source xslDoc = new StreamSource(".\\ingredients.xsl");
            Source xmlDoc = new StreamSource(".\\ingredients.xml");

            String outputFileName = ".\\ingredients.html";
            FileOutputStream htmlFile = new FileOutputStream(outputFileName);
            

            Transformer transformer = tFactory.newTransformer(xslDoc);
            transformer.transform(xmlDoc, new StreamResult(htmlFile));
            
            System.out.println("Done!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}