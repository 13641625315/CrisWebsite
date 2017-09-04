/**
  * Copyright 2017 bejson.com 
  */
package com.cris.website.jasonbean;

/**
 * Auto-generated: 2017-09-04 15:28:1
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class HeWeatherNow {

    private HeWeatherCond cond;
    private String fl;
    private String hum;
    private String pcpn;
    private String pres;
    private String tmp;
    private String vis;
    private HeWeatherWind wind;
    public void setCond(HeWeatherCond cond) {
         this.cond = cond;
     }
     public HeWeatherCond getCond() {
         return cond;
     }

    public void setFl(String fl) {
         this.fl = fl;
     }
     public String getFl() {
         return fl;
     }

    public void setHum(String hum) {
         this.hum = hum;
     }
     public String getHum() {
         return hum;
     }

    public void setPcpn(String pcpn) {
         this.pcpn = pcpn;
     }
     public String getPcpn() {
         return pcpn;
     }

    public void setPres(String pres) {
         this.pres = pres;
     }
     public String getPres() {
         return pres;
     }

    public void setTmp(String tmp) {
         this.tmp = tmp;
     }
     public String getTmp() {
         return tmp;
     }

    public void setVis(String vis) {
         this.vis = vis;
     }
     public String getVis() {
         return vis;
     }

    public void setWind(HeWeatherWind wind) {
         this.wind = wind;
     }
     public HeWeatherWind getWind() {
         return wind;
     }

}