package model;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import database.Database;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;


/**
 a
 */
public class Pdftest extends Repository {

    public static final String logo = "http://www.deltacarrentals.ca/wp-content/uploads/2016/10/delta-car-logo.png";





    public static void gen(ObservableList<Model> modelList){



/*
        ObservableList<String> prName = FXCollections.observableArrayList();
        String x;
        int size = getProduct().size();

        for(int i=0; i < size; ++i)
        {
            x = getProduct().get(i).getName();
            prName.add(i,x);

        }
        */

        BaseFont helvetica;

        Document document = new Document();
        int size = modelList.size();

        try {
            PdfWriter.getInstance(document,
                    new FileOutputStream("rental.pdf"));


            helvetica = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
            Font polskieZnaki=new com.itextpdf.text.Font(helvetica,18);
            Font plTyt=new com.itextpdf.text.Font(helvetica,28);
            Font plPow=new com.itextpdf.text.Font(helvetica,22);

            document.open();


            String imageUrl = "http://www.deltacarrentals.ca/wp-content/uploads/2016/10/delta-car-logo.png";

            Image image = Image.getInstance(new URL(imageUrl));
            image.scaleAbsolute(500f, 150f);
            document.add(image);

            Image logo1 = Image.getInstance(logo);


            Font tytfont = new Font(Font.FontFamily.TIMES_ROMAN, 38);
            Chunk title = new Chunk(" \n \n \n \n \n\n\n\n\n\n\n "
                    + "WYKAZ ŚRODKÓW\n\n\n\n PIĘLĘGNACJI POJAZDÓW   ", plTyt);

            Phrase tytul = new Phrase();
            tytul.add(title);


            Paragraph tytpar = new Paragraph();
            tytpar.add(tytul);
            tytpar.setAlignment(Element.ALIGN_CENTER);

            document.add(tytpar);

            // koniec strony tytulowej

            document.newPage();


            document.add(image);
            //  PdfPTable table = new PdfPTable(2); // 2 kolumny
            //table.setWidthPercentage(100);

            // PdfPCell cell1 = new PdfPCell();
            //  cell1.addElement(logo1);


            // table.addCell(cell1);

            // PdfPCell cell2 = new PdfPCell(new Paragraph("Nazwa firmy kupującej"));
            //table.addCell(cell2);

            //document.add(table);

            //koniec dodania tabeli

            Font podkreslenie = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.UNDERLINE);
            Chunk przerwa = new Chunk("\n\n\n");
            Chunk Spis_tyt = new Chunk("Spis treści", plTyt);


            Phrase tytul_par = new Phrase();
            tytul_par.add(przerwa);
            tytul_par.add(Spis_tyt);
            tytul_par.add(przerwa);


            document.add(tytul_par);

            List spis_lista = new List(List.ORDERED);

            //==========================


            for (int i = 0; i < size; i++)
                spis_lista.add(new ListItem(modelList.get(i).getSurface(),polskieZnaki));



            document.add(spis_lista);


            Database db = new Database();
            Connection conn = db.connectDatabase();

            //koniec spisu treści
            for (int i = 0; i < size; i++) {
                document.newPage();

                Product pr = new Product();
                try {

                    ResultSet rsn = conn.createStatement().executeQuery("SELECT *  FROM  product WHERE name='"+ modelList.get(i).getProduct() + "'");

                    rsn.next();
                    pr.setDosage(rsn.getInt("dosage"));
                    pr.setTemperature((rsn.getInt("temperature")));




                }catch(Exception ex)
                {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, ex.getMessage() + " ", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
                    alert.showAndWait();
                }




//            document.add(table);
                document.add(image);

            /*
            Phrase przerwa_par = new Phrase();
            przerwa_par.add(przerwa);
            document.add(przerwa_par);
*/


                PdfPTable tabela_i = new PdfPTable(1); // 1 kolumny


                tabela_i.setWidthPercentage(100);
                tabela_i.setSpacingBefore(30f);
                tabela_i.setSpacingAfter(10f);

                PdfPCell kom_i = new PdfPCell(new Paragraph(modelList.get(i).getSurface(),plPow));
                //PdfPCell kom_i = new PdfPCell(new Paragraph("" + pr.getDosage())); //niejawnie rzutowanie na stringa ( dlatego nawiaswy)
                kom_i.setHorizontalAlignment(Element.ALIGN_CENTER);
                kom_i.setBorder(Rectangle.NO_BORDER);
                tabela_i.addCell(kom_i);

                document.add(tabela_i);


                PdfPTable tabela_mycia = new PdfPTable(1);

                tabela_mycia.setSpacingBefore(10f);

                tabela_mycia.setSpacingAfter(10f);

                tabela_mycia.setWidthPercentage(100);

                PdfPCell kom_pow = new PdfPCell(new Paragraph("Produkt:\n "+modelList.get(i).getProduct() + "\n\nPotrzebne akcesorium:\n" + modelList.get(i).getAccessories(),polskieZnaki));
                kom_pow.setHorizontalAlignment(Element.ALIGN_LEFT);
                kom_pow.setBorder(Rectangle.NO_BORDER);
                tabela_mycia.addCell(kom_pow);
                //


                //PdfPCell kom_op = new PdfPCell(new Paragraph("Potrzebne akcesorium: " + modelList.get(i).getAccessories(),polskieZnaki));
               // kom_op.setBorder(Rectangle.NO_BORDER);
                //tabela_mycia.addCell(kom_op);

                document.add(tabela_mycia);
                //====================================

                PdfPTable tabela_doz = new PdfPTable(1);

                tabela_doz.setSpacingBefore(10f);

                tabela_doz.setSpacingAfter(10f);

                tabela_doz.setWidthPercentage(100);

                PdfPCell kom_doz = new PdfPCell(new Paragraph("Dozowanie: "+pr.getDosage()+"\n\nTemperatura: " + pr.getTemperature()  ,polskieZnaki));
                kom_doz.setHorizontalAlignment(Element.ALIGN_LEFT);
                kom_doz.setBorder(Rectangle.NO_BORDER);
                tabela_doz.addCell(kom_doz);
                //


                PdfPCell kom_non = new PdfPCell(new Paragraph("" ));
                kom_non.setBorder(Rectangle.NO_BORDER);
                tabela_doz.addCell(kom_non);

                document.add(tabela_doz);

                if (i!=0 && i%2 == 0) {
                    document.newPage();
                }

            }


            /*

               PdfPTable tabela_produkt = new PdfPTable(2);

             tabela_produkt.setSpacingBefore(10f);

             tabela_produkt.setSpacingAfter(10f);

             tabela_produkt.setWidthPercentage(100);

            PdfPCell kom_prod = new PdfPCell(new Paragraph("Produkt: \t Nazwa Produktu\n\nTemperatura:\t 20-30 stopni C\n\n Dozowanie:\t 5-30ml/L\n"));

            tabela_produkt.addCell(kom_prod);


            PdfPCell kom_szcz = new PdfPCell(new Paragraph("PUNKTY SZCZEGÓLNEJ UWAGI:\n wypisujemy punkty szczególnej uwagi"));

            tabela_produkt.addCell(kom_szcz);


            document.add(tabela_produkt);

               PdfPTable tabela_akce = new PdfPTable(2);

             tabela_akce.setSpacingBefore(10f);

             tabela_akce.setSpacingAfter(10f);

             tabela_akce.setWidthPercentage(100);

            PdfPCell kom_akce = new PdfPCell(new Paragraph("Akcesoria Pomocnicze:\n wypisujemy akcesoria pomocnicze\n od pauz\n lub bulletpointow"));

            tabela_akce.addCell(kom_akce);


            PdfPCell kom_sporz = new PdfPCell(new Paragraph("Sporządził:/n Tomasz Antkiewicz"));

            tabela_akce.addCell(kom_sporz);


            document.add(tabela_akce);


             PdfPTable tabela_czest = new PdfPTable(1); // 1 kolumny

            tabela_czest.setWidthPercentage(100);

            PdfPCell kom_czest = new PdfPCell(new Paragraph("Częstotliwość mycia wedłuyg ustaleń w procedurze"));
            kom_czest.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell_inst.setBorder(Rectangle.NO_BORDER);
            tabela_czest.addCell(kom_czest);

             document.add(tabela_czest);

            */

            //I TO SIĘ POWTARZA PRZEZ TYLE RAZY ILE JEST PRODUKT PÓŹNIEJ TO SAMO DO DEZYNFEKCJI

            // document.newPage();


            //  document.add(table);


            // document.add(przerwa_par);

            PdfPTable dez_tabela_inst = new PdfPTable(1); // 1 kolumny

            dez_tabela_inst.setWidthPercentage(100);

            PdfPCell dez_cell_inst = new PdfPCell(new Paragraph("INSTRUKCJA MYCIA I DEZYNFEKCJI"));
            dez_cell_inst.setHorizontalAlignment(Element.ALIGN_CENTER);
            //cell_inst.setBorder(Rectangle.NO_BORDER);
            dez_tabela_inst.addCell(dez_cell_inst);

            document.add(dez_tabela_inst);


            PdfPTable tabela_dez = new PdfPTable(2);

            tabela_dez.setSpacingBefore(10f);

            tabela_dez.setSpacingAfter(10f);

            tabela_dez.setWidthPercentage(100);

            PdfPCell dez_kom_pow = new PdfPCell(new Paragraph("tutaj jest powierzchnia"));
            dez_kom_pow.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabela_dez.addCell(dez_kom_pow);


            PdfPCell dez_kom_op = new PdfPCell(new Paragraph("-tutaj jest opis\n -ale to jest tluższe \n -od pauz\n -albo bulletpointow\n"));

            tabela_dez.addCell(dez_kom_op);


            document.add(tabela_dez);

            PdfPTable dez_tabela_produkt = new PdfPTable(2);

            dez_tabela_produkt.setSpacingBefore(10f);

            dez_tabela_produkt.setSpacingAfter(10f);

            dez_tabela_produkt.setWidthPercentage(100);

            PdfPCell dez_kom_prod = new PdfPCell(new Paragraph("Produkt: \t Nazwa Produktu\n\nTemperatura:\t 20-30 stopni C\n\n Dozowanie:\t 5-30ml/L\n"));

            dez_tabela_produkt.addCell(dez_kom_prod);


            PdfPCell dez_kom_szcz = new PdfPCell(new Paragraph("PUNKTY SZCZEGÓLNEJ UWAGI:\n wypisujemy punkty szczególnej uwagi"));

            dez_tabela_produkt.addCell(dez_kom_szcz);


            document.add(dez_tabela_produkt);

            PdfPTable dez_tabela_akce = new PdfPTable(2);

            dez_tabela_akce.setSpacingBefore(10f);

            dez_tabela_akce.setSpacingAfter(10f);

            dez_tabela_akce.setWidthPercentage(100);

            PdfPCell dez_kom_akce = new PdfPCell(new Paragraph("Akcesoria Pomocnicze:\n wypisujemy akcesoria pomocnicze\n od pauz\n lub bulletpointow"));

            dez_tabela_akce.addCell(dez_kom_akce);


            PdfPCell dez_kom_sporz = new PdfPCell(new Paragraph("Sporządził:\n Tomasz Antkiewicz"));

            dez_tabela_akce.addCell(dez_kom_sporz);


            document.add(dez_tabela_akce);


            PdfPTable deztabela_czest = new PdfPTable(1); // 1 kolumny

//            tabela_czest.setWidthPercentage(100);


            // document.add(tabela_czest);


            //koniec dezynfekcji


            document.close(); // no need to close PDFwriter?


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}


