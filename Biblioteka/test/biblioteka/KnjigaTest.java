package biblioteka;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class KnjigaTest {

    @Test
    void testInicijalizacijeKnjige() {
        Knjiga knjiga = new Knjiga();

        assertNotNull(knjiga);
    }

    @Test
    void testSetNaslov() {
        Knjiga knjiga = new Knjiga();
        String naslov = "Harry Potter and the Philosopher's Stone";

        knjiga.setNaslov(naslov);

        assertEquals(naslov, knjiga.getNaslov());
    }

    @Test
    void testSetNaslovNull() {
        Knjiga knjiga = new Knjiga();

        assertThrows(NullPointerException.class, () -> {
            knjiga.setNaslov(null);
        });
    }

    @Test
    void testSetNaslovPrazan() {
        Knjiga knjiga = new Knjiga();

        assertThrows(IllegalArgumentException.class, () -> {
            knjiga.setNaslov("");
        });
    }

    @Test
    void testSetIsbn() {
        Knjiga knjiga = new Knjiga();
        long isbn = 1234567890;

        knjiga.setIsbn(isbn);

        assertEquals(isbn, knjiga.getIsbn());
    }

    @Test
    void testSetIsbnOutOfRange() {
        Knjiga knjiga = new Knjiga();

        assertThrows(IllegalArgumentException.class, () -> {
            knjiga.setIsbn(123456789); // Manje od 10 cifara
        });

        assertThrows(IllegalArgumentException.class, () -> {
            knjiga.setIsbn(12345678901234567L); // Više od 13 cifara
        });
    }

    @Test
    void testSetIzdavac() {
        Knjiga knjiga = new Knjiga();
        String izdavac = "Izdavacka kuca";

        knjiga.setIzdavac(izdavac);

        assertEquals(izdavac, knjiga.getIzdavac());
    }

    @Test
    void testSetIzdanje() {
        Knjiga knjiga = new Knjiga();
        int izdanje = 2;

        knjiga.setIzdanje(izdanje);

        assertEquals(izdanje, knjiga.getIzdanje());
    }

    @Test
    void testSetIzdanjeNegativno() {
        Knjiga knjiga = new Knjiga();

        assertThrows(IllegalArgumentException.class, () -> {
            knjiga.setIzdanje(-1);
        });
    }

    @Test
    void testSetAutori() {
        Knjiga knjiga = new Knjiga();
        List<Autor> autori = new ArrayList<>();
        autori.add(new Autor("Pera", "Peric"));
        autori.add(new Autor("Mika", "Mikic"));

        knjiga.setAutori(autori);

        assertEquals(autori, knjiga.getAutori());
    }
    
    @Test
    void testEquals() {
        Knjiga knjiga1 = new Knjiga();
        knjiga1.setIsbn(1234567890);

        Knjiga knjiga2 = new Knjiga();
        knjiga2.setIsbn(1234567890);

        assertEquals(knjiga1, knjiga2);
    }

    @Test
    void testNotEquals() {
        Knjiga knjiga1 = new Knjiga();
        knjiga1.setIsbn(1234567890);

        Knjiga knjiga2 = new Knjiga();
        knjiga2.setIsbn(9876543210L);

        assertNotEquals(knjiga1, knjiga2);
    }
}