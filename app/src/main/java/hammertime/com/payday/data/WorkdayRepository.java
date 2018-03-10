package hammertime.com.payday.data;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * The repository is a class that abstracts access to multiple data sources.
 * It handles the data operations and provide a clean API for the rest of
 * the app for app data.
 */
public class WorkdayRepository
{
    private WorkdayDao workdayDao;
    private LiveData<List<Workday>> allWorkdays;

    // Note that in order to unit test the WordRepository, you have to remove the Application
    // dependency. This adds complexity and much more code, and this sample is not about testing.
    // See the BasicSample in the android-architecture-components repository at
    // https://github.com/googlesamples
    //TODO: fix
    public WorkdayRepository(Application application)
    {
        WorkdayDatabase db = WorkdayDatabase.getDatabase(application);
        workdayDao = db.workdayDao();
        allWorkdays = workdayDao.getAllWorkdays();
    }

    public LiveData<List<Workday>> getAllWorkdays()
    {
        return allWorkdays;
    }

    public void insertWorkday(Workday workday)
    {
        new insertAsyncTask(workdayDao).execute(workday);
    }

    private static class insertAsyncTask extends AsyncTask<Workday, Void, Void>
    {
        private WorkdayDao mAsyncTaskDao;

        insertAsyncTask(WorkdayDao dao)
        {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Workday... params) {
            mAsyncTaskDao.insertWorkday(params[0]);
            return null;
        }
    }
}
