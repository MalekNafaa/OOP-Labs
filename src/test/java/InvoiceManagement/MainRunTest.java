package InvoiceManagement;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainRunTest {
    static List<Invoice> invoices= new ArrayList<>();

    @BeforeEach
    void loadInvoices(){
        invoices=InvoiceProcessor.loadInvoices("Invoices.cvs");
    }

    @Test
    void IfFieldsMissing_ThrowCustomException(){
        assertThrows(InvalidInvoiceException.class,() -> InvoiceProcessor.loadInvoices("prazanSam.csv"));

    }
    @Test
    void IfFieldMissing_assertCauseIsFileNotFoundException(){
        assertAll(
                ()->  assertEquals(1500,invoices.get(1).getTotalAMount()),
                ()->    assertEquals(6,invoices.size())

        );

    }
    @Test
    void ifFileMissing_assertCauseIsFileNotFoundException(){
        try{
            InvoiceProcessor.loadInvoices("hahahaNemaaME.csv");
        }catch(RuntimeException e){
            assertTrue(e.getCause() instanceof FileNotFoundException);
            //assertInstanceOf(FileNotFoundException.class, e.getCause());
        }
    }


}