package com.ita.edu.teachua.utils.jdbc.entity;

import java.util.ArrayList;
import java.util.List;

public class LocationEntity {
    public static final String SELECT_ALL = "SELECT * FROM locations ORDER BY id;";
    private Long id;
    private String address;
    private Double latitude;
    private Double longitude;
    private String name;
    private Long centerId;
    private Long cityId;
    private Long clubId;
    private Long districtId;
    private Long stationId;
    private String phone;


    public LocationEntity(Long id, String address, Double latitude, Double longitude, String name, Long centerId, Long cityId, Long clubId, Long districtId, Long stationId, String phone) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.centerId = centerId;
        this.cityId = cityId;
        this.clubId = clubId;
        this.districtId = districtId;
        this.stationId = stationId;
        this.phone = phone;
    }

    public LocationEntity() {
        this.address = null;
        this.centerId = 0l;
        this.cityId = 0l;
        this.clubId = 0l;
        this.districtId = 0l;
        this.id = 0l;
        this.latitude = null;
        this.longitude = null;
        this.name = null;
        this.phone = null;
        this.stationId = 0l;
    }

    public static LocationEntity getLocation(List<String> row) {
        LocationEntity location = new LocationEntity();
        location.setId(Long.parseLong(row.get(0)));
        location.setAddress(row.get(1));
        if (row.get(2) != null) {
            location.setLatitude(Double.parseDouble(row.get(2)));
        }
        if (row.get(3) != null) {
            location.setLongitude(Double.parseDouble(row.get(3)));
        }
        location.setName(row.get(4));
        if (row.get(5) != null) {
            location.setCenterId(Long.parseLong(row.get(5)));
        }
        if (row.get(6) != null) {
            location.setCityId(Long.parseLong(row.get(6)));
        }
        if (row.get(7) != null) {
            location.setClubId(Long.parseLong(row.get(7)));
        }
        if (row.get(8) != null) {
            location.setDistrictId(Long.parseLong(row.get(8)));
        }
        if (row.get(9) != null) {
            location.setStationId(Long.parseLong(row.get(9)));
        }
        location.setPhone(row.get(10));

        return location;
    }

    public static List<LocationEntity> getLocations(List<List<String>> rows) {
        List<LocationEntity> locations = new ArrayList<>();
        for (List<String> row : rows) {
            locations.add(getLocation(row));
        }
        return locations;
    }

    public String getAddress() {
        return address;
    }

    public Long getCenterId() {
        return centerId;
    }

    public Long getCityId() {
        return cityId;
    }

    public Long getClubId() {
        return clubId;
    }

    public Long getDistrictId() {
        return districtId;
    }

    public Long getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCenterId(Long centerId) {
        this.centerId = centerId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public void setDistrictId(Long districtId) {
        this.districtId = districtId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "LocationEntity{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                ", centerId=" + centerId +
                ", cityId=" + cityId +
                ", clubId=" + clubId +
                ", districtId=" + districtId +
                ", stationId=" + stationId +
                ", phone='" + phone + '\'' +
                '}';
    }
}
