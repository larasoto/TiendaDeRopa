package com.mindhub.tiendaderopa.servicios;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.mindhub.tiendaderopa.modelos.Cliente;
import com.mindhub.tiendaderopa.modelos.Compra;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GeneradorPDFServicio {
    public void export(HttpServletResponse response, Cliente cliente, Compra compra, String amount) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font letraTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        letraTitulo.setSize(18);

        letraTitulo.setColor(Color.LIGHT_GRAY);

        Paragraph titulo = new Paragraph("Artículos", letraTitulo);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);

        Font letraParrafo = FontFactory.getFont(FontFactory.HELVETICA);
        letraParrafo.setSize(12);

        PdfPTable tabla = new PdfPTable(4);

        tabla.setWidthPercentage(100f);
        tabla.setWidths(new float[]{2.0f, 5.0f, 3.0f, 3.0f});
        tabla.setSpacingBefore(10);

        escribirCabeceraTabla(tabla);
        escribirDatosTabla(tabla, cliente, compra, amount);

        Paragraph parrafo = new Paragraph("Resumen de compra");
        parrafo.setAlignment(Paragraph.ALIGN_CENTER);

        Paragraph balance = new Paragraph("Importe total: $" + compra.getMonto() + " - N° Ticket: ");
        balance.setAlignment(Paragraph.ALIGN_LEFT);

//        Image logo = Image.getInstance("./src/main/resources/static/images/logo_pdf.png");
//        logo.setAlignment(Image.ALIGN_CENTER);

//        document.add(logo);
        document.add(titulo);
        document.add(parrafo);
        document.add(balance);
        document.add(tabla);
        document.close();
    }

    private void escribirCabeceraTabla(PdfPTable tabla) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.LIGHT_GRAY);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        cell.setPhrase(new Phrase("Fecha", font));
        tabla.addCell(cell);

        cell.setPhrase(new Phrase("Artículo", font));
        tabla.addCell(cell);

        cell.setPhrase(new Phrase("Descripción", font));
        tabla.addCell(cell);

        cell.setPhrase(new Phrase("Monto", font));
    }

    private void escribirDatosTabla(PdfPTable tabla, Cliente client, Compra compra, String amount) {
        PdfPCell newCell = new PdfPCell();
        newCell.setBackgroundColor(Color.WHITE);
        newCell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLACK);

        DateTimeFormatter aformatter = DateTimeFormatter.ofPattern("dd/MM/yyy - HH:mm");

    //    Set<Compra> pagos = carrito.getBalance();

        AtomicInteger numero = new AtomicInteger();
        numero.set(1);

        changeColor(numero, newCell, font);

        newCell.setPhrase(new Phrase(LocalDate.now().format(aformatter), font));
        tabla.addCell(newCell);
    }

    public static boolean esPar(int numero) {
        return numero % 2 == 0;
    }

    public static void changeColor(AtomicInteger numero, PdfPCell newCell, Font font) {
        if (esPar(numero.get())) {
            newCell.setBackgroundColor(Color.LIGHT_GRAY);
            font.setColor(Color.DARK_GRAY);
        } else {
            newCell.setBackgroundColor(Color.WHITE);
            font.setColor(Color.BLACK);
        }
    }
}
