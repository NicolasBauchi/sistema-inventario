package com.inventario.service;

import com.inventario.models.Equipo;
import org.springframework.stereotype.Service;
import javax.print.*;
import java.awt.print.PrinterException;

@Service
public class ImprimirEtiqueta {

    public void imprimir(Equipo eq){


        try {
            PrintService ps = PrintServiceLookup.lookupDefaultPrintService();

            DocPrintJob docPJ = ps.createPrintJob();
            DocFlavor dFlavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; //BYTE_ARRAY.AUTOSENSE
            Doc d = null;

            String data = eq.generarTicket();
            if (data.equals("")){
                data = "el archivo estaba vacío, por algún motivo no carga.";
            }

            d = new SimpleDoc(data.getBytes(), dFlavor, null); //.getBytes()


            docPJ.print(d,null);

            //con esto la informacion sale vacía. Imprime pero vacio.


        }catch (PrintException ex){
            ex.printStackTrace();
        }

    }

}
