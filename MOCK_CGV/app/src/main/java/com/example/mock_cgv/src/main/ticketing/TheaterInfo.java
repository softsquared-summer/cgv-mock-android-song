package com.example.mock_cgv.src.main.ticketing;

class TheaterInfo {
    private String theaterRoomId;
    private String theaterId;
    private String theaterName;
    private String floor;
    private String roomid;


    public TheaterInfo(String theaterRoomId, String theaterId, String theaterName, String floor, String roomid) {
        this.theaterRoomId = theaterRoomId;
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.floor = floor;
        this.roomid = roomid;
    }

    public void setTheaterRoomId(String theaterRoomId) {
        this.theaterRoomId = theaterRoomId;
    }

    public void setTheaterId(String theaterId) {
        this.theaterId = theaterId;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getTheaterRoomId() {
        return theaterRoomId;
    }

    public String getTheaterId() {
        return theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getFloor() {
        return floor;
    }

    public String getRoomid() {
        return roomid;
    }
}