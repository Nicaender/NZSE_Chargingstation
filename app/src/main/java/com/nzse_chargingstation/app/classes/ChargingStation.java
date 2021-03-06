package com.nzse_chargingstation.app.classes;

import com.google.android.gms.maps.model.LatLng;

/**
 * A class of charging station that consists of address, type of charging device, etc.
 */
public class ChargingStation {

    public ChargingStation(String betreiber,
                           String strasse,
                           String hausnummer,
                           String adresszusatz,
                           int postleitzahl,
                           String ort,
                           String bundesland,
                           String kreis_kreisfreie_stadt,
                           double breitengrad,
                           @SuppressWarnings("NonAsciiCharacters") double längengrad,
                           String inbetriebnahmedatum,
                           double anschlussleitung,
                           String artDerLadeeinrichtung,
                           int anzahlDerLadepunkte,
                           String steckertypen1,
                           double p1,
                           String pk1,
                           String steckertypen2,
                           double p2,
                           String pk2,
                           String steckertypen3,
                           double p3,
                           String pk3,
                           String steckertypen4,
                           double p4,
                           String pk4) {
        this.betreiber = betreiber;
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        this.adresszusatz = adresszusatz;
        this.postleitzahl = postleitzahl;
        this.ort = ort;
        this.bundesland = bundesland;
        this.kreis_kreisfreie_stadt = kreis_kreisfreie_stadt;
        this.breitengrad = breitengrad;
        this.längengrad = längengrad;
        this.inbetriebnahmedatum = inbetriebnahmedatum;
        this.anschlussleitung = anschlussleitung;
        this.artDerLadeeinrichtung = artDerLadeeinrichtung;
        this.anzahlDerLadepunkte = anzahlDerLadepunkte;
        this.steckertypen1 = steckertypen1;
        this.p1 = p1;
        this.pk1 = pk1;
        this.steckertypen2 = steckertypen2;
        this.p2 = p2;
        this.pk2 = pk2;
        this.steckertypen3 = steckertypen3;
        this.p3 = p3;
        this.pk3 = pk3;
        this.steckertypen4 = steckertypen4;
        this.p4 = p4;
        this.pk4 = pk4;
        this.position = new LatLng(this.breitengrad, this.längengrad);
    }

    private final String betreiber;
    private final String strasse;
    private final String hausnummer;
    private final String adresszusatz;
    private final int postleitzahl;
    private final String ort;
    private final String bundesland;
    private final String kreis_kreisfreie_stadt;
    private final double breitengrad;
    @SuppressWarnings("NonAsciiCharacters")
    private final double längengrad;
    private final String inbetriebnahmedatum;
    private final double anschlussleitung;
    private final String artDerLadeeinrichtung;
    private final int anzahlDerLadepunkte;
    private final String steckertypen1;
    private final double p1;
    private final String pk1;
    private final String steckertypen2;
    private final double p2;
    private final String pk2;
    private final String steckertypen3;
    private final double p3;
    private final String pk3;
    private final String steckertypen4;
    private final double p4;
    private final String pk4;
    private final LatLng position;
    private boolean isFiltered = false;
    private boolean showMarker = true;

    public String getBetreiber() {
        return betreiber;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public String getAdresszusatz() {
        return adresszusatz;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public String getBundesland() {
        return bundesland;
    }

    public String getKreis_kreisfreie_stadt() {
        return kreis_kreisfreie_stadt;
    }

    public double getBreitengrad() {
        return breitengrad;
    }

    @SuppressWarnings("NonAsciiCharacters")
    public double getLängengrad() {
        return längengrad;
    }

    public String getInbetriebnahmedatum() {
        return inbetriebnahmedatum;
    }

    public double getAnschlussleitung() {
        return anschlussleitung;
    }

    public String getArtDerLadeeinrichtung() {
        return artDerLadeeinrichtung;
    }

    public int getAnzahlDerLadepunkte() {
        return anzahlDerLadepunkte;
    }

    public String getSteckertypen1() {
        return steckertypen1;
    }

    public double getP1() {
        return p1;
    }

    public String getPk1() {
        return pk1;
    }

    public String getSteckertypen2() {
        return steckertypen2;
    }

    public double getP2() {
        return p2;
    }

    public String getPk2() {
        return pk2;
    }

    public String getSteckertypen3() {
        return steckertypen3;
    }

    public double getP3() {
        return p3;
    }

    public String getPk3() {
        return pk3;
    }

    public String getSteckertypen4() {
        return steckertypen4;
    }

    public double getP4() {
        return p4;
    }

    public String getPk4() {
        return pk4;
    }

    public LatLng getPosition() {
        return position;
    }

    public boolean isFiltered() {
        return isFiltered;
    }

    public void setFiltered(boolean filtered) {
        isFiltered = filtered;
    }

    public boolean isShowMarker() {
        return showMarker;
    }

    public void setShowMarker(boolean showMarker) {
        this.showMarker = showMarker;
    }
}