package hammertime.com.payday;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import hammertime.com.payday.entity.Workday;

public class WorkdayLab
{
    private static WorkdayLab workdayLab;
    private List<Workday> workdayList;

    public WorkdayLab(Context context)
    {
        workdayList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            Workday workday = new Workday();
            workday.setShiftStart(new Date());
            workday.setShiftEnd(new Date());
            workday.setHoursWorked(7.5);
            workday.setUnpaidBreak(30);
            workday.setNotes("Test length of notes");
            workdayList.add(workday);
        }
    }

    public static WorkdayLab get(Context context)
    {
        if (workdayLab == null)
        {
            workdayLab = new WorkdayLab(context);
        }

        return workdayLab;
    }

    public List<Workday> getWorkdayList()
    {
        return workdayList;
    }

    public Workday getWorkday(UUID uuid)
    {
        for (Workday workday: workdayList)
        {
            if (workday.getId().equals(uuid))
            {
                return workday;
            }
        }

        return null;
    }
}
