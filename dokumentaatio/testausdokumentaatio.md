##TESTAUSDOKUMENTAATIO
Automaattisia testejä ei rakennettu GUI -luokalle eikä DataParser -luokalle.
Ohjeistuksen mukaan testejä ei pitänyt rakentaakaan GUI:lle, mutta DataParserin
testauksen tarpeellisuus jäi hieman tulkinnanvaraiseksi. En lopulta tehnyt sille
automaattisia testejä, sillä luokan tehtävä oli vain lukea Scannerin avulla
tekstitiedostoa ja lisätä lukemiaan (String) rivejä List -tyyppiseen olioon.
En tehnyt tälle luokalle testejä, sillä en kokenut tarpeelliseksi testata luokkaa,
jonka toiminta nojaa näin merkittävässä määrin Javan omiin metodeihin ja olioihin (Scanner).

Testasin kuitenkin käsin myös GUI -luokan toimintaa. Ohjelma ei näyttänyt kaatuvan missään seuraavista testitapauksista:
- syötetään akvaarion koon kohdalle tekstiä (esim. "sata", "KALAKONE" ja "hermanni123")
- syötetään liian pieni akvaarion koko (esim. 35 tai -7)
- ohjelma ei anna klikata muita näppäimiä ennen kuin hyväksytty akvaarion koko on syötetty
- etsitään tietoja lajista, jota ohjelma ei tunne (esim. "tappajahai" tai "kahenKilonSIIIIKA")
- etsitään tietoja listan lajista, mutta kirjoitetaan se CapsLockilla (esim."NEONTETRA" tai "SeepRApleKO"); ohjelma löytää tiedot kirjaimien koosta riippumatta
- lisätään laji listalle, jota ohjelma ei tunne (esim. "isopurjepleko")
- lisätään listalla oleva laji, mutta käytetään CapsLockia; laji lisätään kirjaimien koosta riippumatta
- "valmis" nappulaa ei ole mahdollista klikata, ennenkuin vähintään 1 laji on lisätty

Ylläolevissa tapauksissa, jossa käyttäjä syötti virheellistä tekstiä, saatiin asianmukaiset virheilmoitukset ohjelman kaatumatta.
Ohjelma keskeytti etenemisen virheellisiin syöttöihin, ja jäi odottamaan kelvollisia syötteitä.

En havainnut ohjelmassa bugeja. Ohjelman käynnistyminen ei kestä kauaa ja käytössä ei normaalisti havaita hidastelua tai muita ongelmia.

