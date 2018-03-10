package hammertime.com.payday.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import hammertime.com.payday.data.Workday;
import hammertime.com.payday.data.WorkdayRepository;

public class WorkdayViewModel extends AndroidViewModel
{
    private WorkdayRepository repository;
    private LiveData<List<Workday>> allWorkdays;

    public WorkdayViewModel (Application application)
    {
        super(application);
        repository = new WorkdayRepository(application);
        allWorkdays = repository.getAllWorkdays();
    }

    //Hides the implementation from the UI
    public LiveData<List<Workday>> getAllWorkdays()
    {
        return allWorkdays;
    }

    //Hides the implementation from the UI
    public void insertWorkday(Workday workday)
    {
        repository.insertWorkday(workday);
    }
}
