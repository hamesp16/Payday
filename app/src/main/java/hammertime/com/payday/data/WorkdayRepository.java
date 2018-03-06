package hammertime.com.payday.data;

import android.arch.lifecycle.LiveData;

import java.util.List;

public class WorkdayRepository
{
    private final WorkdayDao workdayDao;

    public WorkdayRepository(WorkdayDao workdayDao)
    {
        this.workdayDao = workdayDao;
    }

    public LiveData<List<Workday>> getListOfWorkdays()
    {
        return workdayDao.loadAllWorkdays();
    }

    public LiveData<Workday> getWorkday(String workdayId)
    {
        return workdayDao.getWorkdayById(workdayId);
    }

    public void insertWorkday(Workday workday)
    {
        workdayDao.insertWorkday(workday);
    }

    public void deleteWorkday(Workday workday)
    {
        workdayDao.deleteWorkday(workday);
    }
}
