package de.exxcellent.challenge;

public interface WeatherData {
    public int getDay(int index);
    public float getMxT(int index);
    public float getMnT(int index);
    public float getAvT(int index);
    public float getAvDP(int index);
    public float get1HrP_TPcpn(int index);
    public float getPDir(int index);
    public float getAvSp(int index);
    public float getDir(int index);
    public float getMxS(int index);
    public float getSkyC(int index);
    public float getMxR(int index);
    public float getMn(int index);
    public float getR_AvSLP(int index);

    public int getNumberEntries();
}
