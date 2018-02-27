package hammertime.com.payday.entity;

import java.util.Date;
import java.util.UUID;

public class Workday
{
    private UUID id;
    private Date shiftStart;
    private Date shiftEnd;
    private double hoursWorked;
    private long unpaidBreak;
    private long overtimeHours;
    private String notes;

    public Workday()
    {
        this.id = UUID.randomUUID();
    }

    public UUID getId()
    {
        return id;
    }

    public Date getShiftStart()
    {
        return shiftStart;
    }

    public void setShiftStart(Date shiftStart)
    {
        this.shiftStart = shiftStart;
    }

    public Date getShiftEnd()
    {
        return shiftEnd;
    }

    public void setShiftEnd(Date shiftEnd)
    {
        this.shiftEnd = shiftEnd;
    }

    public double getHoursWorked()
    {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked)
    {
        this.hoursWorked = hoursWorked;
    }

    public long getUnpaidBreak()
    {
        return unpaidBreak;
    }

    public void setUnpaidBreak(long unpaidBreak)
    {
        this.unpaidBreak = unpaidBreak;
    }

    public long getOvertimeHours()
    {
        return overtimeHours;
    }

    public void setOvertimeHours(long overtimeHours)
    {
        this.overtimeHours = overtimeHours;
    }

    public String getNotes()
    {
        return notes;
    }

    public void setNotes(String notes)
    {
        this.notes = notes;
    }
}