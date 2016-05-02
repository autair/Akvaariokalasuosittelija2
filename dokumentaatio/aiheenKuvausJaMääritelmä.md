###Aihemäärittely
####**Aihe:**
Akvaariokalasuosittelija. Tarkoituksena on tuottaa ohjelma, joka suosittelee käyttäjän akvaarioon sopivia kaloja.
Akvaariokaloilla on yleisestä harhaluulosta huolimatta erilaisia vesiarvoihin, ruokintaan, seuralaisiin ja akvaarion kokoon liittyviä vaatimuksia. Aivan kuten pieniä villakoiria ei voi käyttää vetokoirina, eivät myöskään kaikki kalat sovi kaikkiin akvaarioihin tai keskenään yhteen. Ohjelman pohjana käytetään tietokantaa, johon on kerätty tietoa eri kalalajeista.
Tämä ohjelma suunnitellaan vain makeanveden seura- ja lajiakvaarioita silmälläpitäen. 
Ohjelman oletuksena on, että 1cm kalan pituutta tarvitsee yhden litran vettä. Tämä pätee, koska ohjelmassa käsitellään vain pienehköjä, seura-akvaarioihin soveltuvia lajeja. Ohjelma suosittelee kaloja vain vähintään 40 litraisiin akvaariohin.
####**Käyttäjät:**
Tavallinen käyttäjä
####**Kaikkien käyttäjien toiminnot:**
- akvaarion koon syöttö
- itseä miellyttävien lajien valinta
- lajien tietojen katselu

####**Muuta huomioitavaa aiheesta:**
Akvaarioharrastajilla on jo aktiivinen keskustelupalsta [Aqua-Web](http://aqua-web.fi/), joten tähän ohjelmaan ei rakenneta keskustelu- tai arvosteluominaisuuksia. Tämä ohjelma rakennetaan puhtaasti auttamaan uusia harrastajia sopivien kalojen löytämiseen.

####**Luokkien sanallinen kuvaus:**
Ohjelman kannalta keskeisin luokka on FishReferee, joka hoitaa sopivien lajien suosittelun akvaarioon. Lajien tiedot sijaitsevat tekstitiedostossa, jonka lukemisen DataParser -luokka hoitaa. Library -luokan tehtävänä on luoda Species -luokan lajiolioita DataParserista saatavan tiedon perusteella. Lisäksi Library luo listan lajeista annetun akvaarion koon mukaan. Tämä lista annetaan FishRefereelle, joka päivittää tätä listaa käyttäjän valintojen ja lajien vesiarvovaatimusten mukaisesti. Printer -luokka tulostaa FishRefereen tietoja GUI:lle. Species, Fish ja Aquarium kuvaavat enimmäkseen vain ominaisuuksia, eivätkä sisällä varsinaista toiminnallisuutta juuri ollenkaan.

####**Luokkakaavio:**
![Luokkakaavio](/theNEWClassDiagram.png)

####**Sekvenssikaavio tapauksesta, jossa käyttäjä syöttää akvaarion koon:**
![sekvenssikaavio1](/uusisekvenssikaavio1.png)

####**Sekvenssikaavio tapauksesta, jossa käyttäjä valitsee ensimmäisen kalalajin:**
Huom. metodikutsu getAvailableSpecies() FishRefereelle kulkee ylläolevan kaavion tapaan vielä Printer -luokan kautta.
![sekvenssikaavio2](/sekvenssikaavio2.png)
