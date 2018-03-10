package hammertime.com.payday.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.Date;

@Database(entities = {Workday.class}, version = 1, exportSchema = false)
public abstract class WorkdayDatabase extends RoomDatabase
{
    public abstract WorkdayDao workdayDao();

    private static WorkdayDatabase INSTANCE;

    //Makes the database a Singleton to prevent having multiple
    //instances of the database open at the same time
    static WorkdayDatabase getDatabase(final Context context)
    {
        if (INSTANCE == null)
        {
            synchronized (WorkdayDatabase.class)
            {
                if (INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WorkdayDatabase.class, "workday_database")
                            .addCallback(workdayDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }

    private static WorkdayDatabase.Callback workdayDatabaseCallback =
            new WorkdayDatabase.Callback()
            {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db)
                {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void>
    {
        private final WorkdayDao dao;

        PopulateDbAsync(WorkdayDatabase db)
        {
            dao = db.workdayDao();
        }

        @Override
        protected Void doInBackground(final Void... voids)
        {
            dao.deleteAll();

            for (int i = 0; i < 100; i++)
            {
                Workday workday = new Workday();
                workday.setShiftStart(new Date());
                workday.setShiftEnd(new Date());
                workday.setHoursWorked(7.5);
                workday.setOvertimeHours(0);
                workday.setUnpaidBreak(30);
                workday.setNote("Dette er et notat");
                dao.insertWorkday(workday);
            }

            return null;
        }
    }
}
