package de.exxcellent.challenge;

public interface WeatherData {
    public int getDay(int index);
    public int getMxT(int index);
    public int getMnT(int index);
    public int getAvT(int index);
    public float getAvDP(int index);
    public int get1HrP_TPcpn(int index);
    public int getPDir(int index);
    public float getAvSp(int index);
    public int getDir(int index);
    public int getMxS(int index);
    public float getSkyC(int index);
    public int getMxR(int index);
    public int getMn(int index);
    public float getR_AvSLP(int index);

    public int getNumberEntries();
}
