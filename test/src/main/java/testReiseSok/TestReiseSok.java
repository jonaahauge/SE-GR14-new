package testReiseSok;

import domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class TestReiseSok {
    StoppeSted sarpsborg = new StoppeSted("Sarpsborg");
    StoppeSted fredrikstad = new StoppeSted("Fredrikstad");
    StoppeSted halden = new StoppeSted("Halden");

    Rute sarp_fred = new Rute("Sarpsborg-Fredrikstad", new Buss("Buss"),new ArrayList<>(Arrays.asList(sarpsborg.getName(),fredrikstad.getName())));
    Rute halden_sarp = new Rute("Halden-Sarpsborg", new Buss("Buss"), new ArrayList<>(Arrays.asList(halden.getName(),sarpsborg.getName())));
    ArrayList<Rute> testruter = new ArrayList<Rute>(Arrays.asList(sarp_fred, halden_sarp));

    @Test
    public void testReiseSokSingel() throws Exception{
        ReiseSok reiseSok_1 = new ReiseSok(sarpsborg, fredrikstad, testruter);

        Assertions.assertEquals(1, reiseSok_1.getAntallReiser());
        Assertions.assertEquals(2, reiseSok_1.getReiser().getFirst().getAntallstop());
        Assertions.assertEquals("Sarpsborg", reiseSok_1.getReiser().getFirst().getStoppesteder().getFirst().getName());
        Assertions.assertEquals("Fredrikstad", reiseSok_1.getReiser().getFirst().getStoppesteder().getLast().getName());
        Assertions.assertEquals("Sarpsborg-Fredrikstad", reiseSok_1.getReiser().getFirst().getRuter().getFirst().getName());
    }

    @Test
    public void testReiseSokDobbel() throws Exception {
        ReiseSok reiseSok_2 = new ReiseSok(halden, fredrikstad, testruter);

        Assertions.assertEquals(1, reiseSok_2.getAntallReiser());
        Assertions.assertEquals(3, reiseSok_2.getReiser().getFirst().getAntallstop());
        Assertions.assertEquals("Halden", reiseSok_2.getReiser().getFirst().getStoppesteder().getFirst().getName());
        Assertions.assertEquals("Fredrikstad", reiseSok_2.getReiser().getFirst().getStoppesteder().getLast().getName());
        Assertions.assertEquals("Halden-Sarpsborg", reiseSok_2.getReiser().getFirst().getRuter().getFirst().getName());
        Assertions.assertEquals("Sarpsborg-Fredrikstad", reiseSok_2.getReiser().getFirst().getRuter().getLast().getName());
        Assertions.assertEquals("Sarpsborg", reiseSok_2.getReiser().getFirst().getOverganger().getFirst().getOvergang().getName());
    }
}
