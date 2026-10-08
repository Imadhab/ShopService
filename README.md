Shop Service (Erweitert)

Programmierung: ShopService

Heute dreht sich alles um die ShopService-Aufgabe. Füge Tests für alle Schritte in der Aufgabe hinzu oder schreibe sie, sofern nicht anders angegeben.

Klone die Beispiellösung: ShopService. Ihr werdet heute in neuen Gruppenkonfigurationen arbeiten und solltet Erfahrung im Umgang mit unbekanntem Code sammeln. Arbeitet daher bitte auf Basis der Beispiellösung aus dem letzten Modul.

Entferne nun den Link zum GitHub-Repository von Florian, indem du im Menü “Git” auswählst, dann “Manage Remotes” und den Eintrag “origin” entfernst.

Lade das Projekt als neues Repository auf einem deiner eigenen GitHub-Accounts hoch: Wähle in IntelliJ im geklonten Projekt “Git”, dann “GitHub” und wähle “Share Project on GitHub”.

Die Beispiellösung ist nun der Hauptzweig deines GitHub-Repositorys.

Programmierung: Bestellstatus

Füge der Bestellung (Order) einen Bestellstatus hinzu (PROCESSING, IN_DELIVERY, COMPLETED), um den Status der Bestellung zu bestimmen.

Erstelle dazu einen neuen Branch, erstelle und pushe die Commits, erstelle einen Pull Request, überprüfe den PR und merge ihn in den Hauptzweig.

Programmierung: Bestellstatus

Schreibe eine Methode im ShopService, die eine Liste aller Bestellungen mit einem bestimmten Bestellstatus (Parameter) mithilfe von Streams zurückgibt.

Programmierung: Optionales Produkt

Modifiziere die Methode ‘getProductById’ in deinem ProductRepo so, dass sie ein Optional zurückgibt, wenn das Produkt existiert, andernfalls ein leeres Optional.

Programmierung: Ausnahmen (Exceptions)

Modifiziere die Methode ‘addOrder’ im ShopService so, dass eine Ausnahme geworfen wird, wenn das Produkt nicht existiert.

Programmierung: Lombok

Füge eine Methode ‘updateOrder’ im ShopService hinzu, die die Bestellung basierend auf einer orderId und einem neuen Bestellstatus aktualisiert. Verwende die Lombok-Annotation @With dafür.

Programmierung: Bestelldatum

Erweitere das Order-Objekt um ein Feld, das den Bestellzeitstempel speichert. Fülle dieses Feld in der Methode ‘addOrder’ mit dem aktuellen Zeitstempel.

Dieser Zeitstempel sollte als Beweismittel vor Gericht verwendet werden können, wenn Kunden behaupten, sie hätten die Bestellung nicht aufgegeben. Überlege, welcher Datentyp am besten geeignet ist, auch wenn Kunden aus dem Ausland bestellen.

Bonus: Einrichtung im Hauptrepo

Erstelle eine Main-Klasse mit einer Main-Methode. Erstelle in dieser Methode eine Instanz des ShopService.

Die konkreten Instanzen für OrderRepo und ShopRepo sollten ebenfalls hier in der Main-Methode erstellt werden. Übergib sie an den ShopService-Konstruktor. Verwende die Annotation @RequiredArgsConstructor im ShopService, um einen entsprechenden Konstruktor zu generieren.

Definiere drei konkrete Bestellungen und füge sie alle dem ShopService hinzu.

Bonus: ID-Generierung

Erstelle einen IdService zur Generierung einer ID, der in der Methode generateId eine neue UUID zurückgibt (mit java.util.UUID). Erstelle eine konkrete Implementierung des IdService in der Main-Methode und übergib sie an den ShopService-Konstruktor.

Bonus: Ausstehende Bestellungen

Schreibe eine Methode getOldestOrderPerStatus, die eine Map mit dem ältesten Order-Objekt pro Status zurückgibt.

Bonus: Transaction File

Lass die Main Methode eine Datei transactions.txt im folgendem Format lesen:

addOrder A 1 2 3
addOrder B 4 1
setStatus A COMPLETED
printOrders
Diese Datei sollte eine Liste von Befehlszeilen enthalten, die der ShopService ausführen soll.

Unterstützte Befehle

addOrder

Fügt eine neue Bestellung hinzu.
Die Bestellung sollte die angegebenen Produkt-IDs enthalten.
Der Status der Bestellung sollte PROCESSING sein.

Syntax:

addOrder [ ...]

Speichere die vom ShopService zurückgegebene OrderID in einer Datenstruktur
(mit dem angegebenen, frei wählbaren Alias), sodass der Status der Bestellung später geändert werden kann.
setStatus

Setzt den Status einer Bestellung.

Syntax:

setStatus

printOrders

Gibt alle Bestellungen aus.

Bonus: Menge und Lagerbestand

Füge den Produkten eine Menge hinzu.
Wenn ein Produkt bestellt wird, verringert sich die Menge dieses Produkts.
Ist ein Produkt nicht mehr auf Lager, kann es nicht mehr bestellt werden.
Dezimalzahlen sind bei Mengenangaben erlaubt.
Erweitere außerdem die Befehlsverarbeitung entsprechend in der Datei transactions.txt.