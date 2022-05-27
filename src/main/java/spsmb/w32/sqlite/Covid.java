package spsmb.w32.sqlite;

import javafx.beans.property.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


public class Covid {
    private final ReadOnlyIntegerWrapper id =
            new ReadOnlyIntegerWrapper(this, "id", 0);
    private final StringProperty id2 =
            new SimpleStringProperty(this, "id2", null);
    private final StringProperty datum =
            new SimpleStringProperty(this, "datum", null);
    private final IntegerProperty vek =
            new SimpleIntegerProperty(this, "vek", 0);
    private final StringProperty pohlavi =
            new SimpleStringProperty(this, "pohlavi", null);
    private final StringProperty kraj_nuts_kod =
            new SimpleStringProperty(this, "kraj_nuts_kod", null);
    private final StringProperty okres_lau_kod =
            new SimpleStringProperty(this, "okres_lau_kod", null);
    private final SimpleBooleanProperty nakaza_v_zahranici =
            new SimpleBooleanProperty(this, "nakaza_v_zahranici");
    private final StringProperty nakaza_zeme_csu_kod =
            new SimpleStringProperty(this, "nakaza_zeme_csu_kod", null);
    private final SimpleBooleanProperty reportovano_khs =
            new SimpleBooleanProperty(this, "reportovano_khs");

    public Covid(int id, String id2, String datum, int vek, String pohlavi, String kraj_nuts_kod, String okres_lau_kod, boolean nakaza_v_zahranici, String nakaza_zeme_csu_kod, boolean reportovano_khs) {
        this.id.set(id);
        this.id2.set(id2);
        this.datum.set(datum);
        this.vek.set(vek);
        this.pohlavi.set(pohlavi);
        this.kraj_nuts_kod.set(kraj_nuts_kod);
        this.okres_lau_kod.set(okres_lau_kod);
        this.nakaza_v_zahranici.set(nakaza_v_zahranici);
        this.nakaza_zeme_csu_kod.set(nakaza_zeme_csu_kod);
        this.reportovano_khs.set(reportovano_khs);
    }

    public int getId() {
        return id.get();
    }

    public ReadOnlyIntegerWrapper idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getId2() {
        return id2.get();
    }

    public StringProperty id2Property() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2.set(id2);
    }

    public String getDatum() {
        return datum.get();
    }

    public StringProperty datumProperty() {
        return datum;
    }

    public void setDatum(String date) {
        this.datum.set(date);
    }

    public int getVek() {
        return vek.get();
    }

    public IntegerProperty vekProperty() {
        return vek;
    }

    public void setVek(int vek) {
        this.vek.set(vek);
    }

    public String getPohlavi() {
        return pohlavi.get();
    }

    public StringProperty pohlaviProperty() {
        return pohlavi;
    }

    public void setPohlavi(String pohlavi) {
        this.pohlavi.set(pohlavi);
    }

    public String getKraj_nuts_kod() {
        return kraj_nuts_kod.get();
    }

    public StringProperty kraj_nuts_kodProperty() {
        return kraj_nuts_kod;
    }

    public void setKraj_nuts_kod(String kraj_nuts_kod) {
        this.kraj_nuts_kod.set(kraj_nuts_kod);
    }

    public String getOkres_lau_kod() {
        return okres_lau_kod.get();
    }

    public StringProperty okres_lau_kodProperty() {
        return okres_lau_kod;
    }

    public void setOkres_lau_kod(String okres_lau_kod) {
        this.okres_lau_kod.set(okres_lau_kod);
    }

    public boolean isNakaza_v_zahranici() {
        return nakaza_v_zahranici.get();
    }

    public SimpleBooleanProperty nakaza_v_zahraniciProperty() {
        return nakaza_v_zahranici;
    }

    public void setNakaza_v_zahranici(boolean nakaza_v_zahranici) {
        this.nakaza_v_zahranici.set(nakaza_v_zahranici);
    }

    public String getNakaza_zeme_csu_kod() {
        return nakaza_zeme_csu_kod.get();
    }

    public StringProperty nakaza_zeme_csu_kodProperty() {
        return nakaza_zeme_csu_kod;
    }

    public void setNakaza_zeme_csu_kod(String nakaza_zeme_csu_kod) {
        this.nakaza_zeme_csu_kod.set(nakaza_zeme_csu_kod);
    }

    public boolean isReportovano_khs() {
        return reportovano_khs.get();
    }

    public SimpleBooleanProperty reportovano_khsProperty() {
        return reportovano_khs;
    }

    public void setReportovano_khs(boolean reportovano_khs) {
        this.reportovano_khs.set(reportovano_khs);
    }
}


