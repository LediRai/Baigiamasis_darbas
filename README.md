# Baigiamasis_darbas

**Raimondos ir Rasuolės automatinio testavimo kurso baigiamasis darbas:internetinio tinklalapio „Zuza.lt“ automatinis testavimas**


**Turinys**

- Projekto apžvalga
- Funkcionalumai
- Techniniai reikalavimai
- Įdiegimas
- Konfigūracija
- Testų paleidimas
- Jūsų indėlis


**Projekto apžvalga**

„Zuza.lt“ internetinio puslapio testavimas vykdomas naudojant JUnit sistemą Java programinėje kalboje su Selenium biblioteka. Projektui pritaikytas puslapio objektų modelis (POM), kad visi testuojami funkcionalumai būtų organizuotai ir aiškiai išdėstyti projekte. Tokiu būdu galima atskirai leisti skirtingus testų scenarijus pasirinktiems funkcionalumams patikrinti.
Selenium bibliotekos WebDriver įrankis pasitelktas automatizuoti „Chrome“ ir „Firefox“ naršyklėms, kad būtų galima patikrinti, kaip testai veikia skirtingų naršyklių aplinkose.


**Funkcionalumai**

Šie „Zuza.lt“ internetinės svetainės funkcionalumai yra testuojami šiame projekte:
1. sėkminga/ nesėkminga registracija,
2. sėkmingas/ nesėkmingas prisijungimas,
3. sukurto profilio redagavimas bei slaptažodžio keitimas,
4. pristatymo adreso suvedimas,
5. sukurtos paskyros naikinimas,
6. prekių paieška,
7. pirkinių krepšelio papildymas bei ištrynimas,
8. mėgstamiausių prekių sąrašo sudarymas ir panaikinimas,
9. prekės grąžinimas,
10. užklausa dėl nepateikto užsakymo,
11. Meniu skiltis

Taip pat sėkmingai surastos prekės bei mėgstamiausių prekių sąrašas turi pasiekti sukurtą duomenų bazę, naudojant „PostgreSQL“.


**Techniniai reikalavimai**

Testų paleidimas užtikrinamas šiame projekte naudojant ir įdiegiant naujausios versijos:
1. „Java“ programinę kalbą (versija: "1.8.0_371"),
2. „Maven“ įrankį,
3. „Selenium“ biblioteką,
4. „JUnit“ sistemą,
5. „Google Chrome“ naršyklę,
6. „Mozilla Firefox“ naršyklę.
7. „PostgreSQL“ duomenų bazių valdymo sistemą.


**Įdiegimas**


1. Šią saugyklą reikia nuklonuoti jūsų Java paleidimo mašinoje:
https://github.com/LediRai/Baigiamasis_darbas
![clone](clone.png)

2. Pasiekite projekto direktoriją:
![CD](CD.png)

3. Įdiekite projekto integracinius elementus naudodami „Maven“ įrankį:
![mvn](mvn.png)


**Konfigūracija**

Prieš testų paleidimą reikia įsitikinti, kad būtų įdiegti naujausių versijų  naršyklių „paleidėjai“ (drivers). Juos galime atsisiųsti paspaudus ant šių nuorodų:
https://chromedriver.chromium.org/downloads
Laidos · Mozilla/Geckodriver (github.com)
Kai naršyklių „paleidėjai“ (drivers) įdiegti jūsų kompiuterių operacinėse sistemose, nukopijuokite jų direktorijas ir atnaujinkite jas šio projekto testų paleidimo klasėje „ZuzaTestai“.


**Testų paleidimas**

Command prompt arba kitokį terminalą būti projekto viduje ir paleisti šitą komandą: jar cfm YourJarName.jar manifest.txt com example/*.class ir pasileis jar


**Jūsų indėlis**

Jei turite kokių pastebėjimų, pasiūlymų bei idėjų projektą patobulinti, susisiekite su mumis palikdami komentarą šioje saugykloje.




