

			===========Rezolvare probleme apărute==========


	După deschiderea folderului respctiv in Intellij se merge la
butonul ”Add Configuration”, se apasă pe + după care se selectează ”Application”.
Se dă un nume sugestiv, după care ca Main Class se introduce ”ro.mta.se.lab.Main”.
	Ultimul pas aici este adăugarea liniei de comandă care se face selectand Modify Options ==> Add VM Opions și
introducerea liniei de comandă modificând calea ”D:/Meteo-Java-master/” cu calea dvs. Mare atenție la ”/”!

--module-path D:/Meteo-Java-master/javafx-sdk-15.0.1/lib --add-modules javafx.controls,javafx.fxml


	Am făcut asta pentru că nu îmi detecta java sdk 15 instalat în sistem
iar Intellij nu îl găsea ca automatic download in internet.
	Făcand proiectul fără maven nu am un fișier pom.xml cu dependițte și nu am avut de ales decât să descarc java 15 și să forțez VM
să îl adauge pentru a-l recunoaște acesta nefiind detectat după instalarea java sau de către auto donwloader din Intellij.


	Pentru librăria Gson, AnimateFX (am folosit metoda import from Maven).
Pentru a scăpa de erori se intră în File==>Project Structure==>Libraries. Selectăm + și se adaugă
cu Import from Maven astfel: - com.google.code.gson:gson:2.8.6
			     - io.github.typhon0:AnimateFX:1.2.1
se sterg cele vechi
	

	Pentru rezolvarea erorilor legate de jetbrains.annotations din Controller.java selectăm ALT+ENTER pe @NotNull
și se importă librăria lipsă ”Add annotations to classpath” .(Deși e deja în proiect nu înțeleg de ce nu o vede).

	Pentru rezolvarea erorilor din CityTest.java ALT+ENTER pe ”junit” și se selectează
”Add JUnit4 to classpath”.

	Rulăm și mai putem observa o ultimă eroare în MainTest.java. Pentru rezolvarea 
acesteia ALT+ENTER pe @Test după care se selectează ”Add JUnit5.4 to classpath”.

	După terminarea acestor pași aplicația ar trebui sa ruleze perfect. 

	