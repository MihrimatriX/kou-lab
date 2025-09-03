# Fuzzy-Logic-Chip-Quality-Control
Bulanık Mantık Ödevi

## Programın Amacı ve Çalışma Prensibi (Türkçe)

Bu program, çiplerin kalite kontrolünü bulanık mantık yöntemiyle gerçekleştirmek amacıyla geliştirilmiştir. Kullanıcıdan veya bir veri dosyasından alınan çiplerin sıcaklığa dayanıklılık ve sağlamlık değerleri, önceden tanımlanmış bulanık kümeler ve kurallar aracılığıyla değerlendirilir. Sonuç olarak, her bir çip için kalite derecesi hesaplanır ve görsel olarak sunulur.

**Çalışma Adımları:**
1. Sıcaklığa dayanıklılık ve sağlamlık için üyelik fonksiyonları tanımlanır.
2. Kalite dereceleri için üyelik fonksiyonları oluşturulur.
3. Kullanıcıdan veya dosyadan alınan veriler, uygun üyelik fonksiyonlarına göre değerlendirilir.
4. Tanımlı bulanık kurallar uygulanarak kalite derecesi hesaplanır.
5. Sonuçlar grafiklerle görselleştirilir ve kullanıcıya sunulur.

## Kullanım ve Çalıştırma (Türkçe)

### Gereksinimler
- Python 3.x
- Gerekli kütüphaneler: matplotlib, numpy, scikit-fuzzy, scipy

### Kurulum
Gerekli kütüphaneleri yüklemek için:

```bash
pip install matplotlib numpy scikit-fuzzy scipy
```

### Çalıştırma
Ana dizinde:

```bash
python main.py
```

### Kullanım
- Program başladığında, `data.txt` dosyasındaki verilerden birini seçmek için bir indeks girmeniz istenir.
- Seçilen verinin sıcaklık dayanıklılığı ve sağlamlık değerleri kullanılarak kalite derecesi hesaplanır ve grafiklerle gösterilir.
- Farklı verileri seçerek işlemi tekrarlayabilirsiniz.

---

## Purpose and Working Principle (English)

This program is designed to perform chip quality control using fuzzy logic. The temperature resistance and durability values of chips, obtained from the user or a data file, are evaluated through predefined fuzzy sets and rules. As a result, a quality score is calculated for each chip and presented visually.

**Workflow:**
1. Membership functions are defined for temperature resistance and durability.
2. Membership functions are created for quality levels.
3. Data from the user or file is evaluated according to the relevant membership functions.
4. Defined fuzzy rules are applied to calculate the quality score.
5. Results are visualized with graphs and presented to the user.

## Usage and Running (English)

### Requirements
- Python 3.x
- Required libraries: matplotlib, numpy, scikit-fuzzy, scipy

### Installation
To install the required libraries, run the following command in your terminal:

```
pip install -r requirements.txt
```

### Running
Open a terminal in the main directory and run:

```
python main.py
```

### Usage
- When the program starts, you will be prompted to enter an index to select a data row from `data.txt`.
- The selected row's temperature resistance and firmness values will be used to calculate the quality score and display the results with graphs.
- You can repeat the process by selecting different data rows.
