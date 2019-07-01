package view;

import com.itextpdf.text.Document;
import com.itextpdf.text.Header;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import facade.Facade;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Place;

public class PDFGenerator {

        public static void PDFgenerator() {

                Facade facade = Facade.getInstancia();
                Date data = new Date();
                List<Place> list = new ArrayList<Place>();
                SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
                Document document = new Document();
                String time = form.format(data);
                
                try {
                        PdfWriter.getInstance(document, new FileOutputStream("CinemaLog.pdf"));
                        list = facade.listAllPlaces();
                        
                        document.open();
                        
                        document.add(new Paragraph("Cine 90'\n\n"));
                        document.add(new Paragraph("Registro dia " + time));
                        document.add(new Paragraph("\nFuncionário administrador: Elvis Presley"));
                        document.add(new Paragraph("\nRegistro dos clientes ocupantes de acentos da sessão 1\n\n"));
                                                
                        for(Place pl : list){
                                document.add(new Paragraph("Assento: " + pl.getIdPlace()+ 
                                                        "\nNome: " + pl.getClient().getFirstName() + " " + pl.getClient().getLastName()+
                                                        "\nTelefone: " + pl.getClient().getPhone() +
                                                        "\nCPF: " + pl.getClient().getCpf() + "\n\n"));
                        }

                } catch (Exception e) {
                        System.out.println("Erro");

                } finally {
                        document.close();

                }

        }
}
