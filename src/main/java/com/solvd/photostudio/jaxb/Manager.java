package com.solvd.photostudio.jaxb;

import jakarta.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "manager")
@XmlType(propOrder = { "id", "name", "age" })
public class Manager {
    @XmlElement(name = "id")
    private long id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "age")
    private int age;


    public void setName(String name) {
        this.name = name;
    }



    public void setAge(int age) {
        this.age = age;
    }



    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "[Manager: " + name + "; Age: " + age + "]";
    }
}


/*
@XmlRootElement: The name of the root XML element is derived from the class name, and we can also specify the name of the root element of the XML using its name attribute.
@XmlType: define the order in which the fields are written in the XML file
@XmlElement: define the actual XML element name that will be used
@XmlAttribute: define the id field is mapped as an attribute instead of an element
@XmlTransient: annotate fields that we don't want to be included in XML
 */