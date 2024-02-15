package iplookup.Model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * IpData Model
 */
public class IpData {
    // Declare Fields
    private String ip;
    private String country_code;
    private String country_name;
    private String region_name;
    private String city_name;
    private String latitude;
    private String longitude;
    private String zip_code;
    private String time_zone;
    private String asn;
    private String as;
    private boolean is_proxy;

    /**
     * The getIP method returns the IP Address
     * @return the IP Address
     */
    public String getIp() {
        return ip;
    }

    /**
     * The setIp method sets the IP Address
     * @param ip the IP Address
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * The getCountry_code method gets the country code
     * @return the Country Code
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     * The setCountry_code method sets the country code
     * @param country_code the country code
     */
    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    /**
     * The getCountry_name method gets the country name
     * @return the country name
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * THe setCountry_name method sets the country name
     * @param country_name the country name
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    /**
     * The getRegion_name method gets the region name
     * @return the region name
     */
    public String getRegion_name() {
        return region_name;
    }

    /**
     * The setRegion_name method sets the region name
     * @param region_name the region name
     */
    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }

    /**
     * The getCity_name method gets the city name
     * @return the city name
     */
    public String getCity_name() {
        return city_name;
    }

    /**
     * The setCity_name method sets the city name
     * @param city_name the city name
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    /**
     * The getLatitude method gets the latitude
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * The setLatitude methdo sets the latitude
     * @param latitude the latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * The getLongitude method gets the longitude
     * @return the longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * The setLongitude method sets the longitude
     * @param longitude the longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * The getZip_code method gets the zip code
     * @return the zip code
     */
    public String getZip_code() {
        return zip_code;
    }

    /**
     * The setZip_code method sets the zip code
     * @param zip_code the zip code
     */
    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    /**
     * The getTime_zone method gets the time zone
     * @return the time zone
     */
    public String getTime_zone() {
        return time_zone;
    }

    /**
     * The setTime_zone method sets the time zone
     * @param time_zone the time zone
     */
    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    /**
     * The getAsn method gets the asn
     * @return the asn
     */
    public String getAsn() {
        return asn;
    }

    /**
     * The setAsn method sets the asn
     * @param asn the asn
     */
    public void setAsn(String asn) {
        this.asn = asn;
    }

    /**
     * The getAs method gets the as
     * @return the as
     */
    public String getAs() {
        return as;
    }

    /**
     * The setAs method sets the as
     * @param as the as
     */
    public void setAs(String as) {
        this.as = as;
    }

    /**
     * The getIs_proxy method returns the proxy status
     * @return true/false
     */
    public boolean getIs_proxy() {
        return is_proxy;
    }

    /**
     * The setIs_Proxy method sets the proxy status
     * @param is_proxy true/false
     */
    public void setIs_proxy(Boolean is_proxy) {
        this.is_proxy = is_proxy;
    }


}
