package it.test.uvtpoint;

public class UVTModel {
    private String name;
    private double latitude;
    private double longitude;

    public UVTModel(String pName, double pLatitude, double pLongitude) {
        name = pName;
        latitude = pLatitude;
        longitude = pLongitude;
    }

    public String name() { return name; }
    public double latitude() { return latitude; }
    public double longitude() { return longitude; }
}
