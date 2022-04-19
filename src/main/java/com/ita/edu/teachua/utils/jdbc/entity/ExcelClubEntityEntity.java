package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class ExcelClubEntityEntity {

    public static final String SELECT_LAST = "SELECT * FROM excel_club_entity ORDER BY autogenerated_id LIMIT 1;";

    private Long autogeneratedId;
    private String address;
    private String ages;
    private String categories;
    private Long centerExternalId;
    private String cityName;
    private Long clubExternalId;
    private String coordinates;
    private String description;
    private String district;
    private String name;
    private String phone;
    private String station;
    private String webContact;

    public ExcelClubEntityEntity (Long autogeneratedId, String address,String ages, String categories, Long centerExternalId, String cityName, Long clubExternalId, String coordinates, String description, String district, String name, String phone, String station, String webContact){
         this.autogeneratedId = autogeneratedId;
         this.address = address;
         this.ages = ages;
         this.categories = categories;
         this.centerExternalId = centerExternalId;
         this.cityName = cityName;
         this.clubExternalId = clubExternalId;
         this.coordinates = coordinates;
         this.description = description;
         this.district = district;
         this.name = name;
         this.phone = phone;
         this.station = station;
         this.webContact = webContact;
    }

    public ExcelClubEntityEntity (){
        this.autogeneratedId = 0L;
        this.address = null;
        this.ages = null;
        this.categories = null;
        this.centerExternalId = 0L;
        this.cityName = null;
        this.clubExternalId = 0L;
        this.coordinates = null;
        this.description = null;
        this.district = null;
        this.name = null;
        this.phone = null;
        this.station = null;
        this.webContact = null;
    }

    public static ExcelClubEntityEntity getExcelClubEntity(List<String> row) {
        ExcelClubEntityEntity excelClubEntity = new ExcelClubEntityEntity();
        excelClubEntity.setAutogeneratedId(Long.parseLong(row.get(0)));
        excelClubEntity.setAddress(row.get(1));
        excelClubEntity.setAges(row.get(2));
        excelClubEntity.setCategories(row.get(3));
        excelClubEntity.setCenterExternalId(Long.parseLong(row.get(4)));
        excelClubEntity.setCityName(row.get(5));
        excelClubEntity.setClubExternalId(Long.parseLong(row.get(6)));
        excelClubEntity.setCoordinates(row.get(7));
        excelClubEntity.setDescription(row.get(8));
        excelClubEntity.setDistrict(row.get(9));
        excelClubEntity.setName(row.get(10));
        excelClubEntity.setPhone(row.get(11));
        excelClubEntity.setStation(row.get(12));
        excelClubEntity.setWebContact(row.get(13));

        return excelClubEntity;
    }

    public static List<ExcelClubEntityEntity> getExcelClubEntities(List<List<String>> rows) {
        List<ExcelClubEntityEntity> excelClubEntities = new ArrayList<>();
        for (List<String> row : rows) {
            excelClubEntities.add(getExcelClubEntity(row));
        }
        return excelClubEntities;
    }

    public Long getAutogeneratedId() {
        return autogeneratedId;
    }

    public void setAutogeneratedId(Long autogeneratedId) {
        this.autogeneratedId = autogeneratedId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Long getCenterExternalId() {
        return centerExternalId;
    }

    public void setCenterExternalId(Long centerExternalId) {
        this.centerExternalId = centerExternalId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getClubExternalId() {
        return clubExternalId;
    }

    public void setClubExternalId(Long clubExternalId) {
        this.clubExternalId = clubExternalId;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getWebContact() {
        return webContact;
    }

    public void setWebContact(String webContact) {
        this.webContact = webContact;
    }

    @Override
    public String toString() {
        return "ExcelClubEntityEntity{" +
                "ages='" + ages + '\'' +
                ", categories='" + categories + '\'' +
                ", centerExternalId=" + centerExternalId +
                ", cityName='" + cityName + '\'' +
                ", clubExternalId=" + clubExternalId +
                ", coordinates='" + coordinates + '\'' +
                ", description='" + description + '\'' +
                ", district='" + district + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", station='" + station + '\'' +
                ", webContact='" + webContact + '\'' +
                ", autogeneratedId=" + autogeneratedId +
                ", address='" + address + '\'' +
                '}';
    }
}