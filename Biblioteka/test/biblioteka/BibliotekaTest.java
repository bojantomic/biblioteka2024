package biblioteka;

import java.time.LocalDateTime;

import org.easymock.EasyMock;
import org.easymock.EasyMockExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import biblioteka.interfejs.BibliotekaInterfejs;
import biblioteka.interfejs.BibliotekaInterfejsTest;
import util.VremenskiServis;

@ExtendWith(EasyMockExtension.class)
class BibliotekaTest extends BibliotekaInterfejsTest {

	@Override
	public BibliotekaInterfejs getInstance() {
		VremenskiServis s = EasyMock.mock(VremenskiServis.class);
		
		EasyMock.expect(s.vratiVreme("Beograd")).andReturn(LocalDateTime.now()).anyTimes();
		
		EasyMock.replay(s);
		
		return new Biblioteka(s);
	}

}
