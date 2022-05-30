package spsmb.sqlite;

import javafx.beans.property.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

//datum, průměrný věk, počet mužů, počet žen, celkový počet

public class Covid {
    private final StringProperty datum = new SimpleStringProperty(this, "datum", "1111-11-11");
    private final DoubleProperty prumer_vek =
            new SimpleDoubleProperty(this, "avg_vek", 0.0);
    private final IntegerProperty pocet_muzi =
            new SimpleIntegerProperty(this, "pocet_muzi", 0);
    private final IntegerProperty pocet_zeny =
            new SimpleIntegerProperty(this, "pocet_zen", 0);
    private final IntegerProperty celkovy_pocet =
            new SimpleIntegerProperty(this, "celkovy_pocet", 0);

    public Covid(String datum, double prumer_vek, int pocet_muzi, int pocet_zen, int celkovy_pocet) {
        this.datum.set(datum);
        this.prumer_vek.set(prumer_vek);
        this.pocet_muzi.set(pocet_muzi);
        this.pocet_zeny.set(pocet_zen);
        this.celkovy_pocet.set(celkovy_pocet);
    }

    public String getDatum() {
        return datum.get();
    }

    public StringProperty datumProperty() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum.set(datum);
    }

    public double getPrumer_vek() {
        return prumer_vek.get();
    }

    public DoubleProperty prumer_vekProperty() {
        return prumer_vek;
    }

    public void setPrumer_vek(double prumer_vek) {
        this.prumer_vek.set(prumer_vek);
    }

    public int getPocet_muzi() {
        return pocet_muzi.get();
    }

    public IntegerProperty pocet_muziProperty() {
        return pocet_muzi;
    }

    public void setPocet_muzi(int pocet_muzi) {
        this.pocet_muzi.set(pocet_muzi);
    }

    public int getPocet_zeny() {
        return pocet_zeny.get();
    }

    public IntegerProperty pocet_zenyProperty() {
        return pocet_zeny;
    }

    public void setPocet_zeny(int pocet_zeny) {
        this.pocet_zeny.set(pocet_zeny);
    }

    public int getCelkovy_pocet() {
        return celkovy_pocet.get();
    }

    public IntegerProperty celkovy_pocetProperty() {
        return celkovy_pocet;
    }

    public void setCelkovy_pocet(int celkovy_pocet) {
        this.celkovy_pocet.set(celkovy_pocet);
    }
}


