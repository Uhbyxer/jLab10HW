package com.danibuiza.jaxb.museum;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Museum containing a name, a city, a permanent exhibition and a special one, these attributes are
 * going to be represented in this order in the generated XML as described in the annotation XmlType
 * 
 * @author dgutierrez-diez
 */
@XmlType( propOrder = { "name", "city", "permanent", "special" } )
@XmlRootElement( name = "MUSEUM" )
public class Museum
{
    String name;

    public String getName()
    {
        return name;
    }

    @XmlElement( name = "MUSEUM_NAME" )
    public void setName( String name )
    {
        this.name = name;
    }

    Boolean childrenAllowed;

    public Boolean getChildrenAllowed()
    {
        return childrenAllowed;
    }

    @XmlAttribute( name = "children_allowed" )
    public void setChildrenAllowed( Boolean childrenAllowed )
    {
        this.childrenAllowed = childrenAllowed;
    }

    Exhibition special;

    public Exhibition getSpecial()
    {
        return special;
    }

    @XmlElement( name = "SPECIAL_EXHIBITION" )
    public void setSpecial( Exhibition special )
    {
        this.special = special;
    }

    public Exhibition getPermanent()
    {
        return permanent;
    }

    @XmlElement( name = "PERMANENT_EXHIBITION" )
    public void setPermanent( Exhibition permanent )
    {
        this.permanent = permanent;
    }

    Exhibition     permanent;
    private String city;

    public void setCity( String city )
    {
        this.city = city;

    }

    @XmlElement( name = "CITY" )
    public String getCity()
    {
        return city;
    }
}
