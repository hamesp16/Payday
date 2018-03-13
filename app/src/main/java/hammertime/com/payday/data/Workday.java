package hammertime.com.payday.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.util.Date;

import hammertime.com.payday.util.DateConverter;

@Entity
@TypeConverters(DateConverter.class)
public class Workday
{
    @PrimaryKey (autoGenerate = true)
    @NonNull
    private int workdayId;

    //TODO: Date does not support timezone etc, change to better alternative
    private Date shiftStart;
    private Date shiftEnd;
    private double hoursWorked;
    private long unpaidBreak;
    private long overtimeHours;
    private double salary;
    private String note;

    @NonNull
    public int getWorkdayId()
    {
        return workdayId;
    }

    public void setWorkdayId(@NonNull int workdayId)
    {
        this.workdayId = workdayId;
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

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }
}