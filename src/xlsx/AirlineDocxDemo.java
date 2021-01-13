package xlsx;

import org.docx4j.dml.wordprocessingDrawing.Inline;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.model.fields.merge.DataFieldName;
import org.docx4j.model.fields.merge.MailMerger;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Drawing;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

public class AirlineDocxDemo {


    public static void main(String[] args) throws Exception {

//        /* Create a Docx File Document */
//        WordprocessingMLPackage wordPackage = WordprocessingMLPackage.createPackage();
//        MainDocumentPart mainDocumentPart = wordPackage.getMainDocumentPart();
//        mainDocumentPart.addStyledParagraphOfText("Title", "Hello World!");
//        mainDocumentPart.addParagraphOfText("Welcome To Baeldung");
//
//        /* add paragraph */
//        ObjectFactory factory = Context.getWmlObjectFactory();
//        P p = factory.createP();
//        R r = factory.createR();
//        Text t = factory.createText();
//        t.setValue("Welcome To Baeldung New");
//        r.getContent().add(t);
//        p.getContent().add(r);
//        RPr rpr = factory.createRPr();
//        BooleanDefaultTrue b = new BooleanDefaultTrue();
//        rpr.setB(b);
//        rpr.setI(b);
//        rpr.setCaps(b);
//        Color green = factory.createColor();
//        green.setVal("green");
//        rpr.setColor(green);
//        r.setRPr(rpr);
//        mainDocumentPart.getContent().add(p);
//        File exportFile = new File("resources/docx/welcome.docx");
//
//        /* add img */
//        File image = new File("resources/docx/hello.jpg" );
//        byte[] fileContent = Files.readAllBytes(image.toPath());
//        BinaryPartAbstractImage imagePart = BinaryPartAbstractImage
//                .createImagePart(wordPackage, fileContent);
//        Inline inline = imagePart.createImageInline(
//                "Baeldung Image (filename hint)", "Alt Text", 1, 2, false);
//        P Imageparagraph = addImageToParagraph(inline);
//        mainDocumentPart.getContent().add(Imageparagraph);
//
//        /* add tables */
//        int writableWidthTwips = wordPackage.getDocumentModel()
//                .getSections().get(0).getPageDimensions().getWritableWidthTwips();
//        int columnNumber = 3;
//        Tbl tbl = TblFactory.createTable(3, 3, writableWidthTwips/columnNumber);
//        List<Object> rows = tbl.getContent();
//        for (Object row : rows) {
//            Tr tr = (Tr) row;
//            List<Object> cells = tr.getContent();
//            for(Object cell : cells) {
//                Tc td = (Tc) cell;
//                td.getContent().add(p);
//            }
//        }
//
//        wordPackage.save(exportFile);
//
//
//        /* read document */
//
//        File doc = new File("resources/docx/welcome.docx");
//        WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
//                .load(doc);
//        MainDocumentPart part = wordMLPackage.getMainDocumentPart();
//        String textNodesXPath = "//w:t";
//        List<Object> textNodes= part.getJAXBNodesViaXPath(textNodesXPath, true);
//        for (Object obj : textNodes) {
//            Text text = (Text) ((JAXBElement) obj).getValue();
//            String textValue = text.getValue();
//            System.out.println(textValue);
//        }


        // with jaxb

        try (InputStream inputStream = new FileInputStream(new File("resources/docx/contract_template_new.docx"))) {
            WordprocessingMLPackage template = WordprocessingMLPackage.load(inputStream);
            VariablePrepare.prepare(template);//see notes
            HashMap<DataFieldName, String> mappings = new HashMap<>();
            mappings.put(new DataFieldName("pr1"), "Семен");
            mappings.put(new DataFieldName("pr2"), "Семенов");
            mappings.put(new DataFieldName("pr5"), "JJJ");
//            HashMap<String, String> mappings = new HashMap<>();
//            mappings.put("pr3", "Петров");
//            mappings.put("pr4", "Сидоров");
//            mappings.put("pr5", "Михайлов");
//            mappings.put("pr6", "ЯЯЯЯЯЯЯЯЯЯЯЯЯЯЯЯ");
//
            MailMerger.setMERGEFIELDInOutput(MailMerger.OutputField.REMOVED);
            MailMerger.performMerge(template, mappings, false);
//            template.getMainDocumentPart().variableReplace(mappings);
            template.save(new File("resources/docx/contract_template_out.docx"));
        }


//        // without jaxb
//        WordprocessingMLPackage template = WordprocessingMLPackage.load(new File("resources/docx/contract_template.docx"));
//
//        Map<DataFieldName, String> map = new HashMap<>();
//        map.put(new DataFieldName("pr1"), "Закрутный Евгений Евгеньевич");
//        map.put(new DataFieldName("pr2"), "Ростов - на - Дону");
//
//        MailMerger.setMERGEFIELDInOutput(MailMerger.OutputField.REMOVED);
//        MailMerger.performMerge(template, map, false);
//
//        template.save(new File("resources/docx/contract_template_out.docx"));
//
    }


    private static P addImageToParagraph(Inline inline) {
        ObjectFactory factory = new ObjectFactory();
        P p = factory.createP();
        R r = factory.createR();
        p.getContent().add(r);
        Drawing drawing = factory.createDrawing();
        r.getContent().add(drawing);
        drawing.getAnchorOrInline().add(inline);
        return p;
    }
}
