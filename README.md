# 🌳 MyBinaryTree

Dieses Repository enthält eine vollständige **Implementierung von Binärbäumen (Binary Trees)** in **Java**, inklusive **generischer Version**, **Debugging-Dokumentation** und **JUnit-Tests**.  
Das Ziel dieses Projekts ist es, die grundlegende Funktionsweise und Implementierung von **Baumstrukturen** und deren Operationen zu verstehen.

---

## 📁 Projektstruktur

```

MyBinaryTree/
├── Baum.java                          # Hauptklasse: Grundlegende Baum-Implementierung
├── BinaryBaumList.java                # Erweiterte Version mit Listenverarbeitung
├── Debugg Für Findhöhe Methode.pdf    # Debugging-Dokument für die Höhenberechnung
├── Debugg Für Lösche Knote.pdf        # Debugging-Dokument für Löschvorgänge
├── Debugg Für Print Verfahren.pdf     # Debugging-Dokument für die Ausgabe (Traversal)
├── GenericBaum.java                   # Generische Baum-Implementierung mit <T>
├── JunitTeste.java                    # JUnit-Tests zur Verifikation der Methoden
├── Node.java                          # Knotenklasse für Baumstruktur
├── Test.java                          # Haupt-Testklasse für manuelle Ausführung
└── README.md                          # Diese Datei

````

---

## 🧠 Lernziele

- Verständnis der **Datenstruktur „Binärbaum“**  
- Implementierung von **Einfüge-, Lösch- und Suchmethoden**  
- Nutzung von **Rekursiven Algorithmen** (z. B. für Traversierungen)  
- Einführung in **Generics** für flexible Baumtypen  
- Anwendung von **JUnit** zur automatisierten Testung  
- Debugging und Fehleranalyse durch gezielte Tests  

---

## ⚙️ Hauptkomponenten

### 🔹 `Node.java`
Definiert die Struktur eines Baumknotens mit:
- `value` – Datenwert  
- `left` – Linker Teilbaum  
- `right` – Rechter Teilbaum  

---

### 🔹 `Baum.java`
Implementiert die grundlegende Logik eines **Binärbaums**:
- `insert(int value)` – Fügt ein neues Element hinzu  
- `delete(int value)` – Entfernt ein Element  
- `find(int value)` – Sucht ein bestimmtes Element  
- `printInOrder()` – Gibt den Baum in In-Order aus  
- `getHeight()` – Berechnet die Höhe des Baums  

---

### 🔹 `GenericBaum<T>`
Eine generische Variante der Baumklasse, die beliebige Datentypen unterstützt.  
Diese Version verwendet **Generics** (`<T extends Comparable<T>>`), um Vergleichsoperationen zu ermöglichen.

---

### 🔹 `BinaryBaumList.java`
Alternative Baumdarstellung, die eine **Liste** als Datenstruktur für Traversierungen nutzt.  
Ideal zur Demonstration der Verbindung zwischen **Bäumen und linearen Strukturen**.

---

### 🔹 `JunitTeste.java`
Beinhaltet **automatisierte Tests** (JUnit) zur Überprüfung der Korrektheit der Methoden.

---

## 🧩 Beispielausgabe

```text
Elemente werden eingefügt...
In-Order-Ausgabe: 2 4 5 7 9 12
Knoten gelöscht: 5
In-Order-Ausgabe nach Löschung: 2 4 7 9 12
Baumhöhe: 3
````

---

## ▶️ Ausführung

Kompiliere und führe das Programm über die Konsole aus:

```bash
javac *.java
java Test
```

Oder führe die Tests über **JUnit** in einer IDE wie **IntelliJ IDEA**, **Eclipse** oder **VS Code** aus.

---

## 🧪 Beispiel – Generischer Baum

```java
GenericBaum<String> tree = new GenericBaum<>();
tree.insert("Banane");
tree.insert("Apfel");
tree.insert("Zitrone");
tree.printInOrder();
// Ausgabe: Apfel Banane Zitrone
```

## 🧑‍💻 Autor

**Obai Albek**
Student der Informatik – TH Mannheim
GitHub: [ObaiAlbek](https://github.com/ObaiAlbek)
