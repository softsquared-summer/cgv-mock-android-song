package com.example.mock_cgv.src.ticketing;

public class TimeTableInfo {
    private String uniqueMovieTImeId;
    private String uniqueRoomId;
    private String startTime;
    private String endTime;
    private String seatCount;
    private String totalSeat;

    public TimeTableInfo(String uniqueMovieTImeId, String uniqueRoomId, String startTime, String endTime, String seatCount, String totalSeat) {
        this.uniqueMovieTImeId = uniqueMovieTImeId;
        this.uniqueRoomId = uniqueRoomId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seatCount = seatCount;
        this.totalSeat = totalSeat;
    }

    public String getUniqueMovieTImeId() {
        return uniqueMovieTImeId;
    }

    public void setUniqueMovieTImeId(String uniqueMovieTImeId) {
        this.uniqueMovieTImeId = uniqueMovieTImeId;
    }

    public String getUniqueRoomId() {
        return uniqueRoomId;
    }

    public void setUniqueRoomId(String uniqueRoomId) {
        this.uniqueRoomId = uniqueRoomId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(String seatCount) {
        this.seatCount = seatCount;
    }

    public String getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(String totalSeat) {
        this.totalSeat = totalSeat;
    }
}
