package com.java.basic.chap07_oop2;

interface Parseable {
    public abstract void parse(String fileName);
}

class ParserManagerParent {
    int a = 10;
}

class ParserManager extends ParserManagerParent {
    int a = 5;

    public static Parseable getParser(String type) {
        if (type.equals("XML")) {
            return new XMLParser();
        } else {
            Parseable p = new HTMLParser();
            return p;
        }
    }
}

class XMLParser implements Parseable {

    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " - XML Parsing complete");
    }

}

class HTMLParser implements Parseable {

    @Override
    public void parse(String fileName) {
        System.out.println(fileName + " - HTML Parsing complete");
    }

}

public class ParserTest {
    public static void main(String[] args) {
        ParserManagerParent p2 = new ParserManager();
        System.out.println(p2.a);
        
        Parseable parser = ParserManager.getParser("XML");
        parser.parse("document.xml");

        parser = ParserManager.getParser("HTML");
        parser.parse("document2.html");
    }
}
