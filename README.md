# Meteo-Java
### DESCRIPTION

---

Aplicatia care da prognoza *Meteo* la momentul actual al locatiilor limitate din fisierul
de intrare prin intermediul **OpenWeatherAPI** in format **JSON**.

Pentru utilizare apsati label-ul **"Click Me"** in care se vor incarca numele oraselor si
tarilor aferente acestora. Se alege tara si orasul ***(orasele sunt incarcate dupa selectia tarii)*** si abia apoi se apasa pe **BackArrow**.
Rezultatul sunt datele returnate de OpenWeatherAPI incarcate in interfata. Procesul se poate repeta.

##Librariile folosite pentru acest proiect sunt:

---
- **JavaFX** pentru Core la editarea si lucrarea cu interfete in cod + formatul **@FXML**
- **AnimateFX** librarie cu efecte usor de folosit si modificat, acestea intra in alcatuirea unei clase Wrapper **EffectsHandler.java**
impreuna cu alte efecte lucrate manual din **JavaFX**
- **Gson** implementarea Google a unui parser Json pentru a lucra cu formatul primit *la / de la* API
- **Mockito** si **JUnit** pentru efectuarea unui Unit Test pentru o clasa independenta de tip **DataModel** 
- **ControlsFX** libraria introdusa in SceneBuilder pentru accesul la diferite elemente de interfata **Custom**


##Plugin-uri si Programe folosite pentru acest proiect sunt:

---
1. **SceneBuilder** program ce vine in completarea ***IDE*** (integrated development environment) ca un editor vizual pentru
formatul **FXML** ce usureaza lucrul cu elementele de interfata grafica.
   
2. **PlanUML** plug-in care vine in completarea ***IDE*** ca un editor text cu reguli
si formate **universale UML** si **proprii** pentru generarea diverse diagrame **UML** sub forma de fisiere "**.png**" (sau alte formate).
   
3. **CSS** format stylesheet adaptat la **FXML** cu scopul de a stiliza diverse elemente de interfata.


##Functionare:

---
Elementele **FXML** sunt injectate in **Controller**. In momentul lansarii aplicatiei,
obiectul **WeatherAPI** este initializat si incarcat cu toate tarile si codurile acestora
si toate orasele din fisierul de intrare.
In momentul unei selectii din fereastra **selector.fxml** WeatherAPI va lua in format JSON si popula
interfata cu datele necesare.

##Format Fisier de Intrare

---
###Obiect City
| ID	 | CityName | latitude | longitude| CountryCode
| ----------- | ----------- | ----------- | ----------- | ----------- |
| 819827 | Razvilka | 55.591667 | 37.740833 | RU

#By Crisitan Cazacu
