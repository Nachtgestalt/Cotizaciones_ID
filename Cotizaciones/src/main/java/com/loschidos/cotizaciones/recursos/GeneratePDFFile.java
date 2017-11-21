package com.loschidos.cotizaciones.recursos;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.loschidos.cotizaciones.entity.Cotizacion;

import java.io.*; 


public class GeneratePDFFile {
	 // Fonts definitions (DefiniciÃ³n de fuentes).
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    
    private static final String iTextExampleImage = "/home/xules/codigoxules/iText-Example-image.png";
    /**
     * We create a PDF document with iText using different elements to learn 
     * to use this library.
     * Creamos un documento PDF con iText usando diferentes elementos para aprender 
     * a usar esta librerÃ­a.
     * @param pdfNewFile  <code>String</code> 
     *      pdf File we are going to write. 
     *      Fichero pdf en el que vamos a escribir. 
     */
    public void createPDF(File pdfNewFile, Cotizacion cotizacion) {
    	int suma = 0;
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document();
            try {

                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontrÃ³ el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            // Añadimos los metadatos del PDF
            document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
            document.addSubject("Using iText (usando iText)");
            document.addKeywords("Java, PDF, iText");
            document.addAuthor("CÃ³digo Xules");
            document.addCreator("CÃ³digo Xules");
            
            // Primera página 
            Chunk chunk = new Chunk("Cotizacion para:"+cotizacion.getNombre()+".", chapterFont);
            chunk.setBackground(BaseColor.GRAY);
            //Creemos el primer capÃ­tulo)
            Chapter chapter = new Chapter(new Paragraph(chunk), 1);
            chapter.setNumberDepth(0);
            chapter.add(new Paragraph("Creado por Marketing Alliance", paragraphFont));
            
            Anchor anchor = new Anchor("Tabla con precios", categoryFont);
            anchor.setName("Table export to PDF (Exportamos la tabla a PDF)");
            chapter.add(anchor);
            Paragraph paragraph1 = new Paragraph("(Sujeto a cambios sin previo aviso)");
            paragraph1.setSpacingAfter(5f);
            chapter.add(paragraph1);
            
            Integer numColumns = 3;
            Integer numRows = 4;
            // We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns); 
            // Now we fill the PDF table 
            // Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
            // Fill table rows (rellenamos las filas de la tabla).   
            columnHeader = new PdfPCell(new Phrase("Detalle"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);
            
            columnHeader = new PdfPCell(new Phrase("Tipo"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);
            
            columnHeader = new PdfPCell(new Phrase("Costo"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            columnHeader.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(columnHeader);
            
            table.setHeaderRows(1);
            // Fill table rows (rellenamos las filas de la tabla).                
            for (int row = 0; row < numRows; row++) {
                for (int column = 0; column < numColumns; column++) {
                	switch (column) {
					case 0:
						switch (row) {
						case 0:
							table.addCell("Tipo de publico");
							break;
						case 1:
							table.addCell("Duracion de la campaña");
							break;
						case 2:
							table.addCell("Que pretende comunicar");
							break;
						case 3:
							table.addCell(" ");
							break;
						default:
							break;
						}
						break;
					case 1:
						switch (row) {
						case 0:
							table.addCell(cotizacion.getTipoDePublico());
							break;
						case 1:
							table.addCell(cotizacion.getDuracion());
							break;
						case 2:
							table.addCell(cotizacion.getPretencion());
							break;
						case 3:
							table.addCell("Total");
							break;
						default:
							break;
						}
						break;
					case 2:
						switch (row) {
						case 0:
							table.addCell(Integer.toString(cotizacion.getCostoObjetivo()));
							suma += cotizacion.getCostoObjetivo();
							break;
						case 1:
							table.addCell(Integer.toString(cotizacion.getCostoDuracion()));
							suma += cotizacion.getCostoDuracion();
							break;
						case 2:
							table.addCell(Integer.toString(cotizacion.getCostoTipoProducto()));
							suma += cotizacion.getCostoTipoProducto();
							break;
						case 3:
							table.addCell(Integer.toString(suma));
							break;
						default:
							break;
						}
						break;
					default:
						break;
					}
                }
            }
            chapter.add(table);
            
            // Underline a paragraph by iText (subrayando un pÃ¡rrafo por iText)
            Paragraph paragraphE = new Paragraph("Observaciones");
            DottedLineSeparator dottedline = new DottedLineSeparator();
            dottedline.setOffset(-2);
            dottedline.setGap(2f);
            paragraphE.add(dottedline);
            chapter.addSection(paragraphE);
            
            Paragraph paragraphObservaciones = new Paragraph("Los precios mostrados corresponden a un aproximado y no garantizan ningun resultado. \n"
            		+ "Para campañas de tipo Local tendra un alcance entre 370 y 1800 personas. \n"
            		+ "Para campañas de tipo Regional se garantizan entre 900 y 3800 personas. \n"
            		+ "Para campañas de tipo Nacional se garantizan entre 1900 y 12000 personas. \n"
            		+ "Para campañas de tipo Internacional se garantizan entre 3200 y 15000 personas.");
            chapter.addSection(paragraphObservaciones);
            
            document.add(chapter);
            
            // How to use PdfPTable
            // UtilizaciÃ³n de PdfPTable
            
            // We use various elements to add title and subtitle
            // Usamos varios elementos para aÃ±adir tÃ­tulo y subtÃ­tulo
            
            
            Chapter chapTitle = new Chapter(new Paragraph(anchor), 1);
            Paragraph paragraph = new Paragraph("Do it by Xules (Realizado por Xules)", subcategoryFont);
            Section paragraphMore = chapTitle.addSection(paragraph);
            paragraphMore.add(new Paragraph(""));
            
            // We add the table (AÃ±adimos la tabla)
            paragraphMore.add(table);
            // We add the paragraph with the table (AÃ±adimos el elemento con la tabla).
            document.add(chapTitle);
            
            // Second page - some elements
            // Segunda pÃ¡gina - Algunos elementos
            Chapter chapSecond = new Chapter(new Paragraph(new Anchor("Some elements (AÃ±adimos varios elementos)")), 1);
            Paragraph paragraphS = new Paragraph("Do it by Xules (Realizado por Xules)", subcategoryFont);
            
            Section paragraphMoreS = chapSecond.addSection(paragraphS);
            // List by iText (listas por iText)
            String text = "test 1 2 3 ";
            for (int i = 0; i < 5; i++) {
                text = text + text;
            }
            List list = new List(List.UNORDERED);
            ListItem item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            text = "a b c align ";
            for (int i = 0; i < 5; i++) {
                text = text + text;
            }
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            text = "supercalifragilisticexpialidocious ";
            for (int i = 0; i < 3; i++) {
                text = text + text;
            }
            item = new ListItem(text);
            item.setAlignment(Element.ALIGN_JUSTIFIED);
            list.add(item);
            paragraphMoreS.add(list);
            document.add(chapSecond);
            
            document.close();
            System.out.println("Your PDF file has been generated!(Â¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
}
